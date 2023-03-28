import javax.swing.*;
import java.awt.*;

public class Plant extends JLabel {
    private int health;
    private int attackPower;
    public Plant(ImageIcon icon, int health) {
        super(icon);
        this.health = health;

    }

    public int getHealth() {
        return health;
    }
    public int getAttackPower() {
        return attackPower;
    }

    public void decreaseHealth(int damage) {
        health -= damage;
        if (health <= 0) {
            // Remove plant from frame if health reaches 0
            if (getParent() != null) {
                Container parent = this.getParent();
                parent.remove(this);
                parent.validate();
                parent.repaint();
                //VegetableGrid.getPlants().remove(this);
            }

        }
    }
    public void setPlantIcon(ImageIcon i){
        this.setIcon(i);
    }

    public String toString(){
        return "plant created";
    }
}
