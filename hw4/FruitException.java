/**
 * FruitExcption.java
 * Represents user defined exception for using Fruit and its subclasses
 * 
 * @author    Trushank Dand
 * @author	Anshika Garg
 * Version:  $Id: FruitException.java,v 1.0 2012/09/30 14:15:46 tgd Exp tgd $ 
 * 
 *     
 */
/**
 * class FruitException
 * 
 * Represents user defined exception for using Fruit and its subclasses
 * 
 * @author Trushank Dand
 * @author Anshika Garg
 * 
 *
 */
public class FruitException extends Exception {
    int exceptionNumber = 0;
    double value = 0;
    /**
     * FruitException: Constructor
     * @args exceptionNumber: Number of the exception
     * @args value: wrong value inputed
     */
    FruitException(int exceptionNumber, double value) {
        this.exceptionNumber = exceptionNumber;
        this.value = value;
    }
    /**
     * toString
     * Over-rides the default toString method to return specific error messages
     */
    public String toString() {
        switch (exceptionNumber) {
        case 1:
            return "Weight of Apples can not be negative " + value;
        case 2:
            return "Number of Mangoes can not be negative " + value;
        case 3:
            return "Can not purchase more than 5 apples " + value;
        case 4:
            return "Can not purchase more than 15 peaches " + value;
        case 5:
            return "Unit price can not be negative " + value;
        default:
            return "Unknown Error";
        }
    }
}