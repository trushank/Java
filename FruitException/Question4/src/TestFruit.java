/**
 * TestFruit.java
 * Tests the user defined exceptions
 * 
 * @author    Trushank Dand
 * @author	Anshika Garg
 * Version:  $Id: TestFruit.java,v 1.0 2012/09/30 14:15:46 tgd Exp tgd $ 
 * 
 *     
 */
/**
 * class TestFruit
 * 
 * Tests the user defined exceptions
 * 
 * @author Trushank Dand
 * @author Anshika Garg
 * 
 *
 */
public class TestFruit {
    /**
     * main
     * @args args:not used
     */
    public static void main(String args[]) {
        //Non Exception To Show Normal Execution
        try {
            Apples a = new Apples("Red", 2.0, 5); //1st apple
            Mangos m = new Mangos("Orange", 5, 20.0);
            Peach p = new Peach("Peach", 5, 20.0);
        } catch (FruitException e) {
            System.out.println(e);
        }
        //Weight of apples negative
        try {
            Apples a = new Apples("red", - 20.0, 5.0);
        } catch (FruitException e) {
            System.out.println(e);
        }
        //Number of Man
        try {
            Mangos m = new Mangos("yellow", - 5, 6.0);
        } catch (FruitException e) {
            System.out.println(e);
        }
        //More than 5 apples
        try {
            Apples a = new Apples("red", 20.0, 5.0); //2nd apple
            Apples a1 = new Apples("red", 20.0, 5.0); //3rd apple
            Apples a2 = new Apples("red", 20.0, 5.0); //4th apple
            Apples a3 = new Apples("red", 20.0, 5.0); //5th apple
            Apples a4 = new Apples("red", 20.0, 5.0); //6th apple Exception
        } catch (FruitException e) {
            System.out.println(e);
        }
        //More than 16 peaches
        try {
            Peach p = new Peach("peach", 16, 7.0);
        } catch (FruitException e) {
            System.out.println(e);
        }
        //Unit Price negative
        try {
            Peaches p = new Peach("peach", 3, - 7.0);
        } catch (FruitException e) {
            System.out.println(e);
        }
    }
}