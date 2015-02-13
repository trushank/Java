/**
 * Apples.java
 * Represents apple and its functionality
 * 
 * @author    Trushank Dand
 * @author	Anshika Garg
 *Version:  $Id: Apple.java,v 1.0 2012/09/30 14:15:46 tgd Exp tgd $ 
 * 
 *     
 */

/**
 * class Apples
 * 
 * Represents apple and all its functions
 * 
 * @author Trushank Dand
 * @author Anshika Garg
 * 
 *
 */
class Apples extends Fruit
{
    
    private double weight;
    private double pricePerPound;
 
/**
 * Apples constructor
 * @param color: Color of apple
 * @param weight: weight of apple
 * @param pricePerPound: price per pound of the apple
 * @throws FruitException: 
 */
        public Apples(String color,double weight,double pricePerPound) throws FruitException
        {
            super(color);
            this.color=color;
            this.weight=weight;
            this.pricePerPound=pricePerPound;
        
        }
    
        public double getPrice()
        {
            return pricePerPound;
        }

        public double getWeight()
        {
            return weight;
        }

     
        public String report()
        {
           
            return ("I bought "+getColor()+" apples.");
        }

        public double totalPrice()
        {
            return (weight*pricePerPound);
        }
    
}
