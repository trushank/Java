import java.util.*;

/**
 * 
 * radix.java
 * @author Ashpak
 * @author Trushank
 * Date Nov 30, 2012
 * Version 1.0
 * 
 */

/**
 * class radix Takes input numbers from command line and sorts them using radix
 * sort. Output is displayed on the console.
 */
public class radix {
   static class Node{
	Node previous;
	Node next;
	long value;
	public Node(Node p,Node n,long value){
	    previous=p;
	    next=n;
	}
    }
static class LinkedList{
    Node start,end;
    int length=0;
  public void add(long value){
      if(start==null){
	  Node a=new Node(null, null,value);
	  start=a;
	  end=a;
	  length++;
      }else{
	  Node a=new Node(end, null, value);
	  end.next=a;
	  end=a;
	  length++;
      }
  }
  public long[] toArray(){
      Node iter=start;
      long[] array=new long[length];
      for(int i=0;i<length;i++){
	  array[i]=iter.value;
	  iter=iter.next;
      }
      return array;
  }
    
}
    /**
     * main method reads input from commandline and performs the radix sort
     * method. Displays the merged result and time taken
     */
    public static void main(String arg[]) {
	long timeIn = 0;
	long timeOut = 0;
	long timeToRun = 0;
	long array[] = new long[arg.length];
	int n = arg.length;
	
//Storing commandline input into array
	for (int i = 0; i < arg.length; i++) {

	    array[i] = Integer.parseInt(arg[i]);
	}
	
	timeIn = System.currentTimeMillis();	//Noting start time
	
	//Calculating max digits
	int nod = (int) (Math.log10(Math.pow(n, 2)) / Math.log10(n));
	
//loops for nod times
	for (int k = 1; k <= nod; k++) {
	    LinkedList bucket[] = new LinkedList[n];
	    
	    //Initializing Array of vectors
	    for (int i = 0; i < n; i++) {
		bucket[i] = new LinkedList();
	    }
	    
	    //Inserting Elements 
	    for (int i = 0; i < n; i++) {
		int digit = (int) ((array[i] / Math.pow(n, k - 1)) % n);
		//System.out.println(digit);
		bucket[digit].add(array[i]);
	    }
	    int pos = 0;
	    
	    //Removing elements
	    for (int i = 0; i < n; i++) {
		array = bucket[i].toArray();
		
	    }
	}
	//Calculating execution time
	timeOut = System.currentTimeMillis();
	timeToRun = timeOut - timeIn;
	
	//Printing Sorted Array
	for (int i = 0; i < n; i++) {
	    System.out.print(array[i] + " ");
	}
	System.out.print("\nTime to run: " + timeToRun + "millisecs");
    }
}
