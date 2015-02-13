/**
 * Mangos.java
 * Represents mango and its functionlity
 * 
 * @author    Trushank Dand
 * @author	Anshika Garg
 * Version:  $Id: Mangos.java,v 1.0 2012/09/30 14:15:46 tgd Exp tgd $ 
 * 
 *     
 */
/**
 * class Mangos
 * 
 * Represents mango and its functionlity
 * 
 * @author Trushank Dand
 * @author Anshika Garg
 * 
 *
 */
class Mangos extends Fruit {
    private int number;
    private double priceEach;
    /**
     * Mangos: Constructor
     * @args color: color of the mango
     * @args number: number of mangoes
     * @args priceEach: price of each mango
     */
    public Mangos(String color, int number, double priceEach) throws FruitException {
        super(color);
        if (number < 0) {
            throw new FruitException(2, number);
        }
        if (priceEach < 0) {
            throw new FruitException(5, priceEach);
        }
        this.number = number;
        this.priceEach = priceEach;
    }
    /**
     * getPrice(): returns price of each mango
     */
    public double getPrice() {
        return priceEach;
    }
    /**
     * getNumber(): returns number of mangoes
     */
    public int getNumber() {
        return number;
    }
    /**
     * report(): returns String specifying color of mango bought
     */
    public String report() {
        return ("I bought " + getColor() + " mangoes.");
    }
    /**
     * totalPrice(): returns total price of mangos
     */
    public double totalPrice() {
        return (number * priceEach);
    }
}