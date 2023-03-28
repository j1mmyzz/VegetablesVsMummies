import javax.swing.*;

public class Sunflower extends Plant{
    public Sunflower(){

        super(new ImageIcon("src/Sprites/sunflowerSprite.png"), 100);
        reset();

    }
    public void reset(){
        new Thread(new Runnable(){
            public void run(){
                setPlantIcon(new ImageIcon("src/Sprites/sunflowerSprite.png"));

                if(getHealth()>0) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ImageIcon readySunflower = new ImageIcon("src/Sprites/ReadySunflowerSprite.png");
                    setPlantIcon(readySunflower);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    StartMenu.setSuns(StartMenu.getSuns()+50);
                    VegetableSelection.updateSuns();
                    reset();
                }
            }

        }).start();
    }


}
