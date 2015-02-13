/**
 * 
 * ListIterator.java
 * Implements a list iterator
 * @author Trushank
 * Date Oct 14, 2012
 * Version 1.0
 *
 */
/**
 * ListIterator
 * 
 * @author Trushank Implements a list iterator
 * 
 */
public class ListIterator {
    Node current;
    boolean deleted=true;
PartialLinkedListImpl p;
    public ListIterator(PartialLinkedListImpl p, int index) {
	this.p=p;
	
	index--;
	current =p.getStart();
	while (current.getPrevious() != null) {
	    current = current.getPrevious();
	}
	for(int i=0;i<=index;i++){
	    if(current.getNext()==null){
		System.out.println("Invalid index");
		throw new java.lang.IllegalStateException("Invalid Index");
	    }
	    else{
		current=current.getNext();
	    }
	}
	if(current.getPrevious()!=null){
	    current=current.getPrevious();
	}else{
	    current=new Node(null, p.getStart(), null);
	   
	}

    }

    /**
     * 
     * add adds element before the next element to be returned
     * 
     * @param e
     *            object to be added
     */

    public void add(Object e) {
	if (current == null) {
	    System.out.println("End of list reached");
	    return;
	}
	Node n = new Node(e, current.getNext(), current);
	if(current.getNext()!=null)
	current.getNext().setPrevious(n);
	current.setNext(n);

    }

    /**
     * 
     * hasPrevious checks if list has previous
     * 
     * @return boolean result
     */
    public boolean hasPrevious() {
	if (current == null) {
	    System.out.println("End of list reached");
	    return false;
	}
	if (current.getPrevious() != null)
	    return true;
	return false;
    }

    /**
     * 
     * nextIndex index of next value to be returned
     * 
     * @return index of next value
     */
    public int nextIndex() {
	if (current == null) {
	    System.out.println("End of list reached");
	    return 0;
	}
	
	int index = 0;
	Node n=p.getStart();
	while (n != current.getNext()) {
	    index++;
	    n=n.getNext();
	}
	return index;
    }

    /**
     * 
     * previous returns previous element
     * 
     * @return previous element
     */
    public Object previous() {
	if (current == null) {
	    System.out.println("End of list reached");
	    return null;
	}
if(current.getPrevious()!=null){
    deleted=false;
	current = current.getPrevious();
	return current.getData();
}
else{
    System.out.println("End of list");
    throw new java.lang.IllegalStateException("End of list");
}

    }

    /**
     * 
     * previousIndex returns previous index of the current element
     * 
     * @return previous index of the current element
     */

    public int previousIndex() {
	if (current == null) {
	    System.out.println("End of list reached");
	    return 0;
	}
	Node n = current;
	int index = 0;
	while (n.getPrevious() != null) {
	    n = n.getPrevious();
	}
	while (n != current.getPrevious()) {
	    n = n.getNext();
	    index++;
	}
	return index;
    }

    /**
     * 
     * set adds element in the position returned by next or previous pointer
     * 
     * @param e
     *            element to be set
     */
    public void set(Object e) {
	if (current == null) {
	    System.out.println("End of list reached");
	    return;
	}
	add(e);
	current.getNext().setPrevious(current.getPrevious());
	current.getPrevious().setNext(current.getNext());


    }

    /**
     * hasNext checks if there is next element
     * 
     * @return boolean result
     */
    public boolean hasNext() {
	if (current == null) {
	    System.out.println("End of list reached");
	    return false;
	}
	if (current.getNext() != null)
	    return true;
	return false;
    }

    /**
     * next returns next element
     * 
     * @return data of next element
     */
    public Object next() {
	if (hasNext()) {
	    deleted=false;
	    current = current.getNext();
	    return current.getData();
	}
	return null;
    }

    /**
     * remove removes last value returned
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
