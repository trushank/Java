/**
 * CallByValueOrCopy.java
 * Demonstrates difference between calling parameters by value or by reference
 * 
 * @author    Trushank Dand
 * @author	Anshika Garg
 *Version:  $Id: CallByValueOrCopy.java,v 1.0 2012/09/15 14:15:46 tgd Exp tgd $ 
 * 
 *     
 */


/** 
 * This program displays the functionality of call by value
 * and call by reference. There is a global variable which 
 * is accesed by two different functions and their outputs 
 * are displayed. 
 * 
 * @author      Trushank Dend
 * @id          tgd2900
 *
 * @author      Anshika Garg 
 * @id          axg3637
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * class CallByValueOrCopy
 * 
 * This class displays the functionality of call by value
 * and call by reference. There is a global variable which 
 * is accesed by two different functions and their outputs 
 * are displayed.
 * 
 * @author Trushank Dand
 * @author Anshika Garg
 * 
 *
 */
class CallByValueOrCopy
{
         int number;
	
	 String c;

    public CallByValueOrCopy() //constructor
    {
	number=0;
    }
    
     //value of the number passed is incremented and printed
/**
 * callByValue
 * Increments and prints parameter passed by value
 * @param num: Number being passed by value
 */
    public void callByValue(int num)
    {
	num+=1;
	System.out.println("Inside Call By Value: "+num);
    }
	
    //an object is passed in this case and the values is incremented and printed
/**
 * callByReference
 * Increments and prints parameter passed as reference
 * @param CallByValueOrCopy test: Object test being passed as reference
 */
	public void callByReference(CallByValueOrCopy test)
	{
		test.number+=1;
		System.out.println("Inside Call By Reference: "+test.number);
	}
	
	/**
	 * main: Takes input from user via terminal for option to be selected
	 * @param args
	 */
    public static void main(String args[]) //main of the class
    {
	int user_input=0;
	 InputStreamReader is=new InputStreamReader(System.in);
	 BufferedReader br= new BufferedReader(is);
	
	 CallByValueOrCopy test=new CallByValueOrCopy();//an object is created
	 	 	 
	 	do
		{
		    System.out.println("\nPress 1: Call By Value\nPress 2: Call By Reference\nPress 3: Exit");
		    try{ 
			user_input=Integer.parseInt(br.readLine());
		    }
		    catch(IOException e)
			{
		   System.out.println("Some problem in input");
		   }

	   switch(user_input)
	       {
	       case 1:{
		        test.callByValue(test.number); // call by value called
		        //The number is printed   
			System.out.println("After call by value "+test.number);
			break;
			}
			 case 2:{
			     test.callByReference(test);// call by reference is called
			     //the value of the object is printed
		          System.out.println("After call by reference "+test.number);
			  break;
			  }
			 case 3:
			     System.exit(1);
			     break;
			   default:{
			   System.out.println("You entered the wrong choice");
			  break;
			  }   

			   }
			 
	       }while(true);
    }
}