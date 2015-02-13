/**
 * 
 * Test.java
 * Tests the PartialLinkedListImpl
 * @author Trushank
 * Date Oct 9, 2012
 * Version 1.0
 *
 * 
 */
/**
 * Test Tests the PartialLinkedListImpl
 * 
 * @author Trushank
 * 
 */
public class Test {
    /**
     * Methods in PartialLinkedListImpl
     * 
     * add(Object e) add(int index, Object element) addFirst(Object e)
     * addLast(Object e) descendingIterator() getFirst() getLast()
     * listIterator(int index) remove(Object o) removeFirstOccurrence(Object o)
     * removeLastOccurrence(Object o) toArray()
     */
    public static void main(String args[]) {
	
	//*************************************************************************************************************
	PartialLinkedListImpl list = new PartialLinkedListImpl();
	for (int i = 0; i < 10; i++) {
	    list.add(new Integer(i));
	}

	list.addFirst(new Integer(-1));
	list.addLast(new Integer(10));
	System.out.println("First Element: " + list.getFirst());
	System.out.println("Last Element: " + list.getLast());

	list.remove(new Integer(9));
	list.add(1, new Integer(3));
	list.add(7, new Integer(4));
	list.removeFirstOccurrence(new Integer(4));
	list.removeLastOccurrence(new Integer(3));
	Object[] o = list.toArray();
	for (int i = 0; i < o.length; i++) {
	    System.out.print(o[i] + " ");
	}
	list.remove(new Integer(-1));	//removing -1
	
	//*************************************************************************************************************
	/**
	 * Methods in Iterator hasNext() next() remove()
	 */
	System.out.print("\nDescendingIterator:\n");
	Iterator it = list.descendingIterator();
	if (it.hasNext()) {	
	    it.remove();	//removes 10  (-1 removed previously)
	}
	
	while (it.hasNext()) {
	    System.out.print(it.next() + " ");
	}
	//*************************************************************************************************************
	
	
	/**
	 * Methods in ListIterator add(E e) hasNext() hasPrevious() next()
	 * nextIndex() previous() previousIndex() remove() set(E e)
	 * 
	 */
	System.out.println("\nListIterator:");

	
	list = new PartialLinkedListImpl();
	for (int i = 0; i < 10; i++) {
	    list.add(new Integer(i));
	}

	ListIterator l = list.listIterator(0);

	while (l.hasNext())
	    System.out.print(" " + l.next());	//prints 0-9

	l.remove(); 	// 9 removed

	System.out.println("\nAfter remove:");

	l = list.listIterator(0);// reinitializing to index 0
	while (l.hasNext())
	    // printing
	    System.out.print(" " + l.next());// index at 8

	if (l.hasPrevious()) {
	    System.out.println("\nPrevious value at " + l.previousIndex()
		    + " is " + l.previous());	// prints 7
	}
	if (l.hasNext())
	    System.out.println("Next value at " + l.nextIndex() + " is "
		    + l.next());	// prints 8

	l.set(new Integer(6));	//sets 6 in 8's place

	if (l.hasNext())
	    System.out.println("Value set at " + l.nextIndex() + " is "
		    + l.next());// prints 6

    }

}
