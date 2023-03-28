import javax.swing.*;

public class Zombie extends JLabel {
    private int health;
    private int attackPower;


    public Zombie(ImageIcon icon) {
        super(icon);
        health = 5;
        attackPower = 10;

    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void decreaseHealth(int damage) {
        // Decrease the zombie's health by the given amount
        health -= damage;
        // Check if the zombie has died
        if (health <= 0) {
            // Remove the zombie from the vegetable grid
            getParent().remove(this);
        }
    }
//    public String toString(){
//        return "zombie created";
//    }
}
