/**
 * Apples.java
 * Represents a apple and its functionality
 * 
 * @author    Trushank Dand
 * @author	Anshika Garg
 * Version:  $Id: Apples.java,v 1.0 2012/09/30 14:15:46 tgd Exp tgd $ 
 * 
 *     
 */
/**
 * class Apples
 * 
 * Represents a apple and all its functionality
 * 
 * @author Trushank Dand
 * @author Anshika Garg
 * 
 *
 */
class Apples extends Fruit {
    private String color;
    private double weight;
    private double pricePerPound;
    private static int count = 0;
    /**
     * Apples: Constructor
     * @args color: Color of apple
     * @args weight: weight of apple
     * @args pricePerPound: price per pound of apple
     */
    public Apples(String color, double weight, double pricePerPound) throws FruitException {
        super(color);
        if (weight < 0) {
            throw new FruitException(1, weight);
        }
        if ((count + 1) > 5) {
            throw new FruitException(3, count + 1);
        }
        if (pricePerPound < 0) {
            throw new FruitException(5, pricePerPound);
        }
        this.color = color;
        this.weight = weight;
        this.pricePerPound = pricePerPound;
        count++;
    }
    /**
     * getPrice(): returns pricePerPound of the apple
     */
    public double getPrice() {
        return pricePerPound;
    }
    /**
     * getWeight(): returns the weight of the apple
     */
    public double getWeight() {
        return weight;
    }
    /**
     * report: Returns string specifying color of apple
     */
    public String report() {
        return ("I bought " + getColor() + " apples.");
    }
    /**
     * totalPrice(): returns total cost of apple
     */
    public double totalPrice() {
        return (weight * pricePerPound);
    }
}