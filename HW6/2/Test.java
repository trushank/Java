/**
 * Test.java
 * @author Trushank
 * Date Oct 14, 2012
 * Version 1.0
 */

/**
 * @author Trushank
 * 
 */
public class Test {
    /**
     * 
     * main
     * @param args not used
     */
    public static void main(String args[]) {
	PartialCollectionsImp p = new PartialCollectionsImp();
	PartialLinkedListImpl list = new PartialLinkedListImpl();
	list.add(new Integer(1));
	list.add(new Integer(5));
	list.add(new Integer(3));
	list.add(new Integer(4));
	list.add(new Integer(2));

	// *************************************************************************
	System.out.println("\nOriginal List:");
	Iterator ir = list.descendingIterator();
	while (ir.hasNext()) {
	    System.out.print(ir.next());
	}
	// *************************************************************************
	System.out.println("\nSort (Reverse)");
	p.sort(list);
	ir = list.descendingIterator();
	while (ir.hasNext()) {
	    System.out.print(ir.next());
	}
	// *************************************************************************
	System.out.println("\nComaparator Sort (Reverse)");
	list = new PartialLinkedListImpl();
	list.add(new Integer(1));
	list.add(new Integer(5));
	list.add(new Integer(3));
	list.add(new Integer(4));
	list.add(new Integer(2));
	p.sort(list, new Comparator());
	ir = list.descendingIterator();
	while (ir.hasNext()) {
	    System.out.print(ir.next());
	}
	
	// *************************************************************************
	System.out.println("\nShuffle");
	list = new PartialLinkedListImpl();
	list.add(new Integer(1));
	list.add(new Integer(2));
	list.add(new Integer(3));
	list.add(new Integer(4));
	list.add(new Integer(5));
	
	p.shuffle(list);
	ir = list.descendingIterator();
	while (ir.hasNext()) {
	    System.out.print(ir.next());
	}
	
    }

}
