/* 
 * Peach.java 
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

class Peach implements Fruit
{
    private String color;
    private double weight;
    private double pricePerPound;

        public Peach(String colorP,double weightP,double pricePerPoundP)
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
	 *  return the color of the fruits
	 
	 */
        public String getColor()
        {
            return color;
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

        /**
         * return number of peaches
         */
		public double getNumber()
		{
			return 0.0;
		}
	
	
}
