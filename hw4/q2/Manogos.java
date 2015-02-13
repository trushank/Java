/* 
 * Manogos.java 
 * 
 *  $Id: Manogos.java,v 1.0 2012/09/30 16:15:46  axg $ 
 */


/** 
 * This class describes the  functionality of the Mangoes
 *it return the weight, price and the total price
 *along with the color of the fruit
 * 
 * @author      Anshika
 * @author      Trushank
 */



class Manogos implements Fruit
{
    private String color;
    private double number;
    private double pricePerPound;

        public Mangos(String colorM,double numberM,double pricePerPoundM)
        {
            color=colorM;
            number=numberM;
            pricePerPound=pricePerPoundM;
        }
	
	/**
	 *  return the price per pound of the fruits
	 
	 */
    
        public double getPrice()
        {
            return pricePerPound;
        }

	/**
	 *  return the number of the fruits
	 
	 */
	
        public double getNumber()
        {
            return number;
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
            String FruitName=" mangos";
            return (fruitColor+colorReturn+FruitName);
        }
	
	/**
	 *  return the total price of the fruits
	 
	 */

        public double totalPrice()
        {
            return (number*pricePerPound);
        }
    
	
	
}
