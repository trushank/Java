/* 
 * Fruit.java 
 * 
 *  $Id: Apples.java,v 1.0 2012/09/30 16:15:46  axg $ 
 */


/** 
 * This class describes the  functionality of an abstract class
 *This class calls for the subclass's called Apples, Peaches and Mangoes
 * 
 * @author      Anshika
 * @author      Trushank
 */



public abstract class Fruit
{
    String color=new String();
    /**
     * Fruit: Constructor
     * args:String color
     */
    public Fruit(String color){
	this.color=color;
    }
    
    abstract double totalPrice();

    abstract String report();
    
    /**
     * returns color of fruits
     */
    abstract String getColor(){
	return color;
    }
	
}