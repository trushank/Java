/**
 * Fruit.java
 * Represents abstract Fruit
 * 
 * @author    Trushank Dand
 * @author	Anshika Garg
 * Version:  $Id: Fruit.java,v 1.0 2012/09/30 14:15:46 tgd Exp tgd $ 
 * 
 *     
 */
/**
 * class Fruit
 * 
 * Represents abstract Fruit class
 * 
 * @author Trushank Dand
 * @author Anshika Garg
 * 
 *
 */
public abstract class Fruit {
    String color = new String();
    abstract double totalPrice();
    abstract String report();
    /**
     * Fruit: Constructor
     * @args color: color of the fruit
     */
    public Fruit(String color) {
        this.color = color;
    }
    /**
     * getColor():returns color of the fruit
     */
    public String getColor() {
        return color;
    }
}