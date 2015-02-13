
/**
 * 
 * Iterator.java
 * Implementation of a reverse Iterator
 * @author Trushank
 * Date Oct 13, 2012
 * Version 1.0
 * 
 * 
 */

/**
 * Iterator
 * 
 * @author Trushank Implementation of a reverse Iterator
 */
public class Iterator {
    Node current;
    PartialLinkedListImpl p;
    boolean deleted = false;

    /**
     * Constructor of Iterator
     * 
     * @param any
     *            node in the linked list
     */
    public Iterator(PartialLinkedListImpl p) {
	this.p=p;
	Node n=p.getEnd();
	// go to the last element first
	while (n.getNext() != null) {
	    n = n.getNext();
	}
	current=new Node(null, null, n);
	
    }

    /**
     * hasNext returns boolean specifying if there is a next element
     * 
     * @return boolean specifying if there is a next element
     */

    public boolean hasNext() {
	if (current.getPrevious() != null)
	    return true;
	return false;
    }

    /**
     * next Returns next element(previous)
     * 
     * @return next element(previous)
     * 
     */

    public Object next() {
	if (hasNext()) {
	    deleted = false;
	    current = current.getPrevious();
	    return current.getData();
	} else{
	    System.out.println("No more elements");
	    throw new java.util.NoSuchElementException("No more elements");
	}
    }

    /**
     * remove removes the last value returned by the iterator
     * 
     */

    public void remove() {
	if (!deleted) {
	    deleted = true;
	    if(current.getPrevious()!=null)
	    current.getPrevious().setNext(current.getNext());
	    if(current.getNext()!=null)
	    current.getNext().setPrevious(current.getPrevious());
	    current = current.getPrevious();
	    p.size--;
	} else{
	    System.out.println("Current Element already deleted");
	    throw new java.lang.IllegalStateException(
		    "Current Element already deleted");
	    
	}
    }

}
