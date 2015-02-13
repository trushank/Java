/* 
 * Peaches.java 
 * 
 *  $Id: Apples.java,v 1.0 2012/09/30 16:15:46  axg $ 
 */


/** 
 * This class describes the  functionality of the Peaches
 *it return the weight, price and the total price
 *along with the color of the fruit
 * 
 * @author      Anshika
 * @author      Trushank
 */


class Peaches implements Fruit
{
    private String color;
    private double weight;
    private double pricePerPound;

        public Peaches(String colorP,double weightP,double pricePerPoundP)
        {
            color=colorP;
            weight=weightP;
            pricePerPound=pricePerPoundP;
        }
    
	/**
	 *  return the price per pound of the fruits
	 
	 */
	
        public double getPrice()
        {
            return pricePerPound;
        }

	/**
	 *  return the weight of the fruits
	 
	 */
	
        public double getWeight()
        {
            return weight;
        }
	
	/**
	 *  return the color of the fruits
	 
	 */

        public String getColor()
        {
            return color;
        }
        
	
	public double getNumber()
	{
		return 0.0;
	}
	
	/**
	 *  return the string which describes the color
	 *this function calls getColor() function
	 *which returns the color of the fruit
	 
	 */
        public String report()
        {
            String colorReturn=getColor();
            String fruitColor="I bought ";
            String FruitName=" peaches";
            return (fruitColor+colorReturn+FruitName);
        }
	
	/**
	 *  return the total price of the fruits
	 
	 */

        public double totalPrice()
        {
            return (weight*pricePerPound);
        }
    
}
