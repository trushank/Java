/**
 * Lucas.java
 * Displays first 10 Lucas numbers.
 * 
 * @author    Trushank Dand
 * @author 	Anshika Garg
 *
 *Version:  $Id: Lucas.java,v 1.0 2012/09/14 13:15:46 tgd Exp tgd $ 
 * 
 *     
 */

/**
 * class Lucas
 * Prints first 10 Lucas numbers.
 * 
 * @author Trushank Dand
 * @author Anshika Garg
 * 
 * 
 */
public class Lucas {
    
    /**
	 * Calls method to print 10 Lucas numbers
	 * @param args Command line input (Not used)
	 */
    public static void main(String args[]){
	Lucas test= new Lucas();
	
	 //Print first 10 Lucas numbers. Printing more than 10 supported
	 test.printLucas(10);	
    }
    
    /**
	 * Prints 'n' Lucas numbers after the base numbers 2,1
	 * @param int previous_PreviousLucas: The lucas number previous to the last lucas number
	 * @param int previousLucas: Previous lucas number
	 * @param int n: Number of Lucas numbers to be printed after 2,1
	 */
    private static void nextLucas(int previous_PreviousLucas, int previousLucas, int n){
	
	if(n>0){	//stops when 'n' Lucas numbers are printed
	    
	   int currentLucas= previous_PreviousLucas + previousLucas;
	   System.out.print(currentLucas+" ");		//printing value of current recursion
	   nextLucas(previousLucas, currentLucas, n-1);	//recursing
	   
	}
	
	
    }
    /**
     * Prints 'n' number of Lucas numbers including base numbers 2,1
     * @param n: Number of Lucas Numbers to Be printed
     */
    private void printLucas(int n){
	
	//defining the starting base numbers
	int baseNumber1=2;
	int baseNumbr2=1;
	System.out.print(baseNumber1 + " " + baseNumbr2 + " "); //printing starting numbers
	nextLucas(baseNumber1, baseNumbr2, n-2);
	}

}
