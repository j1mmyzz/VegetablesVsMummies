import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class StartMenu extends JPanel {
    private static boolean sunFlowerClicked, peaShooterClicked, walnutCLicked, cactusClicked, pumpkinCLicked, cherryCLicked, palmTreeClicked;
    private static int suns = 500, waves;
    private Image background; // background image
    private JButton startButton, quitButton; // button to start and end the game
    private VegetableSelection vegetableSelection;
    private VegetableGrid vegetableGrid;
    public StartMenu() {
        // Load background image
        background = new ImageIcon("src/GameBackgrounds/StartMenuBackground.png").getImage();

        // Set up JPanel
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20);

        // Add start button
        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(100, 50)); // Set the size of the button
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_END; // Move the button towards the bottom of the frame
        gbc.weighty = 1;
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear Start Menu
                removeAll();
                revalidate();
                repaint();
                setLayout(new BorderLayout());

                //Add the sun counter and vegetable cards at the top
                try {
                    vegetableSelection = new VegetableSelection();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                vegetableSelection.setPreferredSize(new Dimension(800,100));
                add(vegetableSelection, BorderLayout.NORTH);

                //Add the grid
                try {
                    vegetableGrid = new VegetableGrid();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                vegetableGrid.setPreferredSize(new Dimension(500,500));
                add(vegetableGrid,BorderLayout.CENTER);



                //Update the UI
                revalidate();
                repaint();


            }
        });
        add(startButton, gbc);

       // Add quit button
        gbc.gridy++;
        quitButton = new JButton("Quit");
        quitButton.setPreferredSize(new Dimension(100, 50)); // Set the size of the button
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_END; // Move the button towards the bottom of the frame
        gbc.weighty = 1;

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the program
            }
        });
        add(quitButton, gbc);
   }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
    }
    public static int getSuns(){
        return suns;
    }
    public static void setSuns(int x){
        suns=x;
    }
    public static int getWaves(){
        return waves;
    }
    public static void setWaves(int x){
        waves =x;
    }
    public static boolean getSunFlowerClicked(){
        return sunFlowerClicked;
    }
    public static void setSunFlowerClicked(boolean x){
        sunFlowerClicked = x;
    }
    public static boolean getPeaShooterClicked(){
        return peaShooterClicked;
    }
    public static void setPeaShooterClicked(boolean x){
        peaShooterClicked = x;
    }
    public static boolean getWalnutClicked(){
        return walnutCLicked;
    }
    public static void setWalnutCLicked(boolean x){
        walnutCLicked = x;
    }
    public static boolean getCactusClicked(){
        return cactusClicked;
    }
    public static void setCactusClicked(boolean x){
        cactusClicked = x;
    }
    public static boolean getPumpkinClicked(){
        return pumpkinCLicked;
    }
    public static void setPumpkinCLicked(boolean x){
        pumpkinCLicked = x;
    }
    public static boolean getCherryClicked(){
        return cherryCLicked;
    }
    public static void setCherryCLicked(boolean x){
        cherryCLicked = x;
    }
    public static boolean getPalmTreeClicked(){
        return palmTreeClicked;
    }
    public static void setPalmTreeClicked(boolean x){
        palmTreeClicked = x;
    }
    public static void setAllClicked(boolean x){
        sunFlowerClicked = x;
        peaShooterClicked = x;
        walnutCLicked = x;
        cactusClicked = x;
        pumpkinCLicked = x;
        cherryCLicked = x;
        palmTreeClicked = x;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Vegetables VS Mummies");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new StartMenu());
        frame.setSize(800, 600); // Set the size of the frame
        frame.setVisible(true);
    }
}
