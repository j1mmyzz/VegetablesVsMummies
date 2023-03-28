import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VegetableSelection extends JPanel {
    private static JLabel sunCounter = new JLabel("Suns: " + StartMenu.getSuns());
    JPanel sunAndWaveCounter, plantCards, quitButtonPanel;
    public VegetableSelection() throws IOException {
        sunAndWaveCounter = new JPanel();
        plantCards = new JPanel();
        quitButtonPanel = new JPanel();
        setLayout(new BorderLayout());

        //quit button
        quitButtonPanel.setLayout(new BorderLayout());
        JButton quit = new JButton("Quit Game");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        quitButtonPanel.add(quit ,BorderLayout.CENTER);

        //add the sun and wave counter

        sunAndWaveCounter.add(sunCounter);


        //add the vegetable cards
        //Icon icon = new ImageIcon("E:\editicon.PNG");
        //JButton button7 = new JButton(icon);
        Icon sc = new ImageIcon("src/VegetableCards/SunFlowerCard.png");
        Icon psc = new ImageIcon("src/VegetableCards/peashootercard.png");
        Icon wc = new ImageIcon("src/VegetableCards/pixil-frame-0.png");
        Icon cc = new ImageIcon("src/VegetableCards/pixil-frame-0.png");
        Icon pc = new ImageIcon("src/VegetableCards/pixil-frame-0.png");
        Icon chc = new ImageIcon("src/VegetableCards/pixil-frame-0.png");
        Icon ptc = new ImageIcon("src/VegetableCards/pixil-frame-0.png");

        plantCards.setLayout(new GridLayout(1,7));

        JButton sunflowerCard = new JButton(sc);
        JButton peaShooterCard = new JButton(psc);
        JButton walnutCard = new JButton(wc);
        JButton cactusCard = new JButton(cc);
        JButton pumpkinCard = new JButton(pc);
        JButton cherryCard = new JButton(chc);
        JButton palmTreeCard = new JButton(ptc);
        //Action Listeners for all the plant cards
        sunflowerCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartMenu.setSunFlowerClicked(true);
                StartMenu.setPeaShooterClicked(false);
                StartMenu.setWalnutCLicked(false);
                StartMenu.setCactusClicked(false);
                StartMenu.setPumpkinCLicked(false);
                StartMenu.setCherryCLicked(false);
                StartMenu.setPalmTreeClicked(false);


            }
        });

        peaShooterCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartMenu.setSunFlowerClicked(false);
                StartMenu.setPeaShooterClicked(true);
                StartMenu.setWalnutCLicked(false);
                StartMenu.setCactusClicked(false);
                StartMenu.setPumpkinCLicked(false);
                StartMenu.setCherryCLicked(false);
                StartMenu.setPalmTreeClicked(false);

            }
        });

        walnutCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartMenu.setSunFlowerClicked(false);
                StartMenu.setPeaShooterClicked(false);
                StartMenu.setWalnutCLicked(true);
                StartMenu.setCactusClicked(false);
                StartMenu.setPumpkinCLicked(false);
                StartMenu.setCherryCLicked(false);
                StartMenu.setPalmTreeClicked(false);

            }
        });

        cactusCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartMenu.setSunFlowerClicked(false);
                StartMenu.setPeaShooterClicked(false);
                StartMenu.setWalnutCLicked(false);
                StartMenu.setCactusClicked(true);
                StartMenu.setPumpkinCLicked(false);
                StartMenu.setCherryCLicked(false);
                StartMenu.setPalmTreeClicked(false);
            }
        });

        pumpkinCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartMenu.setSunFlowerClicked(false);
                StartMenu.setPeaShooterClicked(false);
                StartMenu.setWalnutCLicked(false);
                StartMenu.setCactusClicked(false);
                StartMenu.setPumpkinCLicked(true);
                StartMenu.setCherryCLicked(false);
                StartMenu.setPalmTreeClicked(false);
            }
        });

        cherryCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartMenu.setSunFlowerClicked(false);
                StartMenu.setPeaShooterClicked(false);
                StartMenu.setWalnutCLicked(false);
                StartMenu.setCactusClicked(false);
                StartMenu.setPumpkinCLicked(false);
                StartMenu.setCherryCLicked(true);
                StartMenu.setPalmTreeClicked(false);
            }
        });

        palmTreeCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartMenu.setSunFlowerClicked(false);
                StartMenu.setPeaShooterClicked(false);
                StartMenu.setWalnutCLicked(false);
                StartMenu.setCactusClicked(false);
                StartMenu.setPumpkinCLicked(false);
                StartMenu.setCherryCLicked(false);
                StartMenu.setPalmTreeClicked(true);            }
        });







        plantCards.add(sunflowerCard);
        plantCards.add(peaShooterCard);
        plantCards.add(walnutCard);
        plantCards.add(cactusCard);
        plantCards.add(pumpkinCard);
        plantCards.add(cherryCard);
        plantCards.add(palmTreeCard);


        sunAndWaveCounter.setBackground(Color.ORANGE);
        plantCards.setBackground(Color.ORANGE);
        quitButtonPanel.setBackground(Color.yellow);
        quitButtonPanel.setPreferredSize(new Dimension(100,100));
        sunAndWaveCounter.setPreferredSize(new Dimension(100,100));
        add(quitButtonPanel, BorderLayout.EAST);
        add(sunAndWaveCounter, BorderLayout.WEST);
        add(plantCards, BorderLayout.CENTER);
    }
    public static void updateSuns(){
        sunCounter.setText("Suns: " + StartMenu.getSuns());
    }

}
