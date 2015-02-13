import java.util.Scanner;

/**
 * 
 * Test.java
 * @author Trushank
 * Date Oct 7, 2012
 * Version 1.0
 */


/**
 * Test
 * Tests the HashSet class
 * @author Trushank
 * 
 */
public class Test {
    /**
     * 
     * main
     * Tests the HashSet Class
     * @param args
     */
    public static void main(String args[]) {
try{
	Scanner s1 = new Scanner(System.in);
	System.out
		.println("Please enter approximate size of HashSet.\nNext closest Prime number will be selected: ");
	HashSet h1 = new HashSet(s1.nextInt());
	while (true) {
	    System.out
		    .println("1) Add Element\n2) Remove Element\n3) Clear\n4) Find Element");
	    System.out
		    .println("5) Is Empty? \n6) Size\n7) Print\n8) Exit\nPlease Enter Choice: ");

	    switch (s1.nextInt()) {
	    case 1:
		System.out.println("Enter Object to be added");
		h1.add(s1.next());
		break;
	    case 2:
		System.out.println("Enter Object to be removed");
		h1.remove(s1.next());
		break;
	    case 3:
		h1.clear();
		break;
	    case 4:
		System.out.println("Enter Object to be found");
		if (h1.contains(s1.next())) {
		    System.out.println("Object found");
		} else
		    System.out.println("Object not found");
		break;
	    case 5:
		h1.isEmpty();
		break;
	    case 6:
		System.out.println("Number of elements in HashSet: "
			+ h1.size());
		break;
	    case 7:
		h1.print();
		break;
	    case 8:
		return;
	    default:
		System.out.println("Wrong Input");
	    }
	}
}catch(Exception e){
    System.out.println("Incorrect Input. Exitting");
}
	// Can uncomment for quick testing. Enters integers into the hashset and
	// checks the functions
	/*
	 * for (int i = 0; i < 30; i++) { h1.add(new Integer(i)); }
	 * System.out.println("Size of hashset: " + h1.size()); // Printing the
	 * hashsets seperated by *s h1.print();
	 * 
	 * // duplicate entry will give error msg h1.add(new Integer(1));
	 * 
	 * // removing Integer with value of 1 h1.remove(new Integer(1));
	 * System.out.println("Size of hashset: " + h1.size()); h1.print();
	 * 
	 * // Checking if hashset is empty h1.isEmpty()
	 * 
	 * 
	 * // searching for Integer having value 1
	 * 
	 * if(h1.contains(new Integer(1))){ System.out.println("Object found");
	 * } else System.out.println("Object not found");
	 * 
	 * 
	 * // clearing and checking for confirmation of deletion h1.clear();
	 * System.out.println("Size of hashset: " + h1.size());
	 */
    }
}
