/**
 * Peach.java
 * Represents peach and its functionlity
 * 
 * @author    Trushank Dand
 * @author	Anshika Garg
 * Version:  $Id: Peach.java,v 1.0 2012/09/30 14:15:46 tgd Exp tgd $ 
 * 
 *     
 */
/**
 * class Peach
 * 
 * Represents peach and its functionlity
 * 
 * @author Trushank Dand
 * @author Anshika Garg
 * 
 *
 */
class Peach extends Fruit {
    private int number;
    private double priceEach;
    /**
     * Peach:Constructor
     * @args color: Color of the peach
     * @args number: number of peaches
     * @args priceEach: price of each peach
     */
    public Peach(String color, int number, double priceEach) throws FruitException {
        super(color);
        if ((number + 1) > 15) {
            throw new FruitException(4, number + 1);
        }
        if (priceEach < 0) {
            throw new FruitException(5, priceEach);
        }
        this.number = number;
        this.priceEach = priceEach;
    }
    /**
     * getPrice(): returns price of each peach
     */
    public double getPrice() {
        return priceEach;
    }
    /**
     * getNumber(): returns number of peaches
     */
    public int getNumber() {
        return number;
    }
    /**
     * report():Returns a string specifying color of peaches bought
     */
    public String report() {
        return ("I bought " + getColor() + " peaches.");
    }
    /**
     * totalPrice(): returns total price of the peaches
     */
    public double totalPrice() {
        return (number * priceEach);
    }
}