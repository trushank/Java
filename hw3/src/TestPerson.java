/**
 * TestPerson.java
 * Tests functionality offered by the Person and the FireFighter classes
 * 
 * @author    Trushank Dand
 * @author	Anshika Garg
 *Version:  $Id: TestPerson.java,v 1.0 2012/09/23 14:15:46 tgd Exp tgd $ 
 * 
 *     
 */




import java.util.Scanner;


/** 
 * class TestPerson
 * Tests functionality offered by the Person and the FireFighter classes
 * 
 * @author      Trushank Dend
 * @id          tgd2900
 *
 * @author      Anshika Garg 
 * @id          axg3637
  */
public class TestPerson {
    /**
     * main: Creates object of either FireFighter or Person and demostrates functionality
     * @param args (not used)
     */
    public static void main(String args[]) {
	
        Scanner src = new Scanner(System. in );	//Creating Scanner object to accept input
        System.out.println("Enter 1:Person\t2:Firefighter");
        switch (src.nextInt()) {
        case 1:
            //Making a Person object
            Person p = new Person();
            p.display();	//Displaying options
            break;
        case 2:
            //Making a FireFighter object
            FireFighter p1 = new FireFighter();
            p1.display();	//displaying options
            break;

        default:	//default case
            System.out.println("Wrong Input");
        }


    }

}