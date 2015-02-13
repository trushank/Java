/**
 * TotalPrice.java
 * Calculates total price of the fruits
 * 
 * @author    Trushank Dand
 * @author	Anshika Garg
 *Version:  $Id: TotalPrice.java,v 1.0 2012/09/30 14:15:46 tgd Exp tgd $ 
 * 
 *     
 */


import java.util.*; 


/**
 * class TotalPrice
 * 
 * Calculates total price of the fruits
 * 
 * @author Trushank Dand
 * @author Anshika Garg
 * 
 *
 */
class TotalPrice 
{
   
	
	/**
	 * cal:calculates the total price
	 * @param purchasedFruit: Vector of fruits
	 * @return: total price
	 */
	public static double cal(Vector<Fruit> purchasedFruit)
	{
		double price=0.0;
		
		for(int i=0;i<purchasedFruit.size();i++)
        {
			price+=purchasedFruit.get(i).totalPrice(); 
		}
		
		return price;
	}
	
	
	/**
	 * main
	 * @param args:not used
	 */
	public static void main(String args[]) 
	{
        Vector< Fruit > purchasedFruit = new Vector< Fruit >();
		
        // First part: create and add fruit objects to a Vector.
        for (int i = 0; i < 10; i++) 
		{
            purchasedFruit.addElement( new Apples( "red", Math.random() * 10, Math.random() + 1.0 ));
        }
        for (int i = 0; i < 5; i++) 
		{
            purchasedFruit.addElement( new Apples( "green", Math.random() * 10,Math.random() + 1.0 ));
        }
        for (int i = 0; i < 10; i++) 
		{
            purchasedFruit.addElement( new Manogos( "redandgreen", (int)(Math.random() * 10),Math.random() + 0.5 ));
        }
		
       
		double price=cal(purchasedFruit);
		System.out.println(price);
    }
	
}