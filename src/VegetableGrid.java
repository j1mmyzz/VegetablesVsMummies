import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class VegetableGrid extends JPanel {
    private int initialPeaX, initialPeaY;
    private boolean gameOver;
    private int plantWidth = 50;
    private ImageIcon sunflowerSpriteIcon, peaShooterSpriteIcon, walnutSpriteIcon, cactusSpriteIcon, pumpkinSpriteIcon, cherrySpriteIcon, palmTreeSpriteIcon;


    private int plantHeight = 60;
    private ArrayList<Zombie> zombies;
    private static ArrayList<Plant> plants;
    private Image backgroundImage;
    private JLabel zombieLabel;
    private int numZombies = 5, y1 = 40,y2=130,y3=210,y4=295,y5=380;

    public VegetableGrid() throws InterruptedException {
        zombies = new ArrayList<>();
        plants = new ArrayList<>();
        sunflowerSpriteIcon = new ImageIcon("src/Sprites/sunflowerSprite.png");
        peaShooterSpriteIcon = new ImageIcon("src/Sprites/peashooterSprite.png");
        walnutSpriteIcon = new ImageIcon("src/Sprites/smallwallnut.png");
        cactusSpriteIcon = new ImageIcon("src/Sprites/cactusSprite.png");
        pumpkinSpriteIcon = new ImageIcon("src/Sprites/pumpkinSprite.png");
        cherrySpriteIcon = new ImageIcon("src/Sprites/cherrySprite.png");
        palmTreeSpriteIcon = new ImageIcon("src/Sprites/palmtreeSprite.png");

        setLayout(null);
        try {
            backgroundImage = ImageIO.read(new File("src/GameBackgrounds/Map.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int x = e.getX();
                int y = e.getY();
                int xStart = x - (sunflowerSpriteIcon.getIconWidth() / 2);
                int yStart = y - (sunflowerSpriteIcon.getIconHeight() / 2);
                if (StartMenu.getSunFlowerClicked() == true && StartMenu.getSuns()>=100) {
                    StartMenu.setSuns(StartMenu.getSuns()-100);
                    VegetableSelection.updateSuns();
                    Sunflower sunflower = new Sunflower();
                    sunflower.setBounds(xStart, yStart, sunflowerSpriteIcon.getIconWidth(), sunflowerSpriteIcon.getIconHeight());
                    add(sunflower);
                    System.out.println("sunflower added");
                    plants.add(sunflower);
                    repaint();
                    StartMenu.setAllClicked(false);

                }
                if (StartMenu.getPeaShooterClicked() == true && StartMenu.getSuns()>=100) {
                    StartMenu.setSuns(StartMenu.getSuns()-100);
                    VegetableSelection.updateSuns();
                    initialPeaX = e.getX();
                    initialPeaY = e.getY();
                    PeaShooter peaShooter = new PeaShooter();
                    Pea pea = new Pea();
                    pea.setBounds(xStart, yStart, peaShooterSpriteIcon.getIconWidth(), peaShooterSpriteIcon.getIconHeight());

                    peaShooter.setBounds(xStart, yStart, peaShooterSpriteIcon.getIconWidth(), peaShooterSpriteIcon.getIconHeight());
                    add(pea);
                    add(peaShooter);
                    System.out.println("peaShooter added");

                    shoot();

                    plants.add(pea);
                    plants.add(peaShooter);
                    repaint();
                    StartMenu.setAllClicked(false);

                }


            }
        });




        //all possible entity y values
        /*
        40
        130
        210
        295
        380
         */
        //Wait before the game starts
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                    // Spawn zombies here
                    for (int i = 0; i < numZombies; i++) {
                        int yValue = (int)(Math.random()*5);
                        if(yValue == 0){
                            yValue = y1;
                        }
                        else if(yValue == 1){
                            yValue = y2;
                        }
                        else if(yValue ==2){
                            yValue = y3;
                        }
                        else if(yValue == 3){
                            yValue = y4;
                        }
                        else{
                            yValue = y5;
                        }
                        Thread.sleep(3000);
                        numZombies++;


                        ImageIcon zombieIcon = new ImageIcon("src/Sprites/mummySprite.png");
                        JLabel zombieLabel = new JLabel(zombieIcon);
                        zombieLabel.setBounds(800, yValue, 50, 100);
                        add(zombieLabel);
                        int finalYValue = yValue;

                        Zombie zombie = new Zombie(zombieIcon);
                        zombie.setBounds(800, yValue, 50, 100);

                        add(zombie);
                        zombies.add(zombie);
                        System.out.println(zombie.getBounds());



                        Thread zombieMovementThread = new Thread(new Runnable() {
                            public void run() {
                                int x = 800; // initial position outside the panel
                                int y = finalYValue;
                                int dx = -1; // movement speed

                                while (!(x + zombieIcon.getIconWidth() < 0)) {

                                    x += dx; // move zombie to the left

                        // check if zombie is outside the panel (Temporary Delete later)
                        if (x + zombieIcon.getIconWidth() < 0) {
                            // reset zombie position outside the panel
                            System.exit(0);
                        }

                                    // update zombie position
                                    zombie.setBounds(x, y, zombieIcon.getIconWidth(), zombieIcon.getIconHeight());
                                    try {
                                        Thread.sleep(20); // wait a bit before moving again
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                }

                            }
                        });
                        zombieMovementThread.start();

                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("started checking for collosions");
                while(!(gameOver)) {
                    if(plants.size()>0) {
                        for (Zombie zombie : zombies) {
                            for (Plant plant : plants) {
                                if(plant.getHealth()>0) {
                                    if (zombie.getBounds().intersects(plant.getBounds())) {
                                        if(zombie.getParent()!=null){
                                            zombie.decreaseHealth(plant.getAttackPower());
                                            plant.decreaseHealth(zombie.getAttackPower());
                                        }

                                    }
                                }
                            }
                        }
                    }
                    try {
                        Thread.sleep(10); // pause for 10 milliseconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }
    public static ArrayList<Plant> getPlants(){
        return plants;
    }
    public void peaMove(){
        Thread peaMovement = new Thread(new Runnable() {
            public void run() {
                int x = initialPeaX;
                int y = initialPeaY;
                ImageIcon pi = new ImageIcon("src/Sprites/pea.png");
                JLabel peaIcon = new JLabel(pi);
                peaIcon.setBounds(x, y, 50, 100);
                add(peaIcon);

                int dx = 5; // movement speed

                while (!(pi.getIconWidth() < 0)) {
                    x += dx; // move pea to the right

                    // update pea position
                    peaIcon.setBounds(x,y-20 , pi.getIconWidth(), pi.getIconHeight());
                    try {
                        Thread.sleep(20); // wait a bit before moving again
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    for(Zombie zombie : zombies){

                            if(zombie.getHealth()>0) {
                                 if (zombie.getBounds().intersects(peaIcon.getBounds())) {
                                     if(zombie.getParent()!=null){
                                         Container parent = zombie.getParent();
                                         parent.remove(peaIcon);
                                         parent.invalidate();
                                         parent.repaint();
                                         zombie.decreaseHealth(400);

                                     }



                                    }
                                }

                        }


                }

            }
        });
        peaMovement.start();
    }
    public void shoot(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Timer shootTimer = new Timer(2000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // create a new pea and add it to the panel
                        peaMove();

                    }
                });
                shootTimer.start();


            }
        }).start();

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
    }
}
