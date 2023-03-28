import javax.swing.*;

public class PeaShooter extends Plant{
    public PeaShooter(){

        super(new ImageIcon("src/Sprites/peashooterSprite.png"), 100);
    }
    public void shoot() {
        new Thread(new Runnable() {
            public void run() {
                setPlantIcon(new ImageIcon("src/Sprites/sunflowerSprite.png"));


                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    shoot();

            }

        }).start();
    }
}
