/**
 * CashRegister.java
 * Mimics functions of a CashRegister
 * 
 * @author    Trushank Dand
 * @author	Anshika Garg
 *Version:  $Id: CashRegister.java,v 1.0 2012/09/23 16:15:46 tgd Exp tgd $ 
 * 
 *     
 */
import java.util.Scanner;

/** 
 * class CashRegister
 * Mimics the functions of a CashRegister 
 * 
 * @author      Trushank Dend
 * @id          tgd2900
 *
 * @author      Anshika Garg 
 * @id          axg3637
  */

class CashRegister {
    private int count;	//to count number of items
    private double total_price;	//total bill
    
    //Constructor initializing to zero
    public CashRegister() {
        count = 0;
        total_price = 0.0;
    }
    /**
     * clear: clears items and total
     */
    public void clear() {
	//Warning if bill is already empty
        if (count == 0) 
            System.out.println("There are no items");
        count = 0;
        total_price = 0.0;
    }
    /**
     * addItem: Adds item to the bill
     * @param price: price of the item
     */
    public void addItem(double price) {
	//Checking if value is zero or negative
        if (price > 0) {
            count++;
            total_price += price;
        } else System.out.println("Invalid Value");
    }
    /**
     * getCount: Counts the number of items in the bill
     * @return: Count of items in the bill
     */
    public int getCount() {
        return count;
    }
    
    /**
     * getTotalPrice: Returns total amount in the bill
     * @return: total amount in the bill
     */
    public double getTotalPrice() {
        return total_price;
    }
    
    /**
     * main: Initiates CashRegister and gives options
     * @param args: Not used
     */
    public static void main(String args[]) {
	
        CashRegister items = new CashRegister();	//New CashRegister Object
        Scanner sc = new Scanner(System.in );	//Scanner object to take user input
        int input = 0;	//switch case input
        do {
            System.out.println("1:Add an item\n2:Count the no of items in the list\n3:Clear the list of items\n4:Exit");
            input = sc.nextInt();
            switch (input) {
            case 1:
                {
                    System.out.println("Enter the price of the item\n");
                    items.addItem(sc.nextDouble());	//adding item
                    break;
                }
            case 2:
                {
                    //Item count
                    System.out.println("The total no of items are " + items.getCount());	
                    break;
                }
            case 3:
                {
                    //Clear items
                    items.clear();
                    System.out.println("Cleared");
                    break;
                }
            case 4:
                {
                    //Exit
                    System.out.println("Exiting");
                    break;
                }
            default:
                {	
                    //default
                    System.out.println("Not the right input");
                }
            }
        } while (input != 4);	//input=4 ->exit
        sc.close();	//releasing resource
    }
}