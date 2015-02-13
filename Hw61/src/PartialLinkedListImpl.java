/**
 * 
 * PartialLinkedListImpl.java
 * Implements a partial linked list
 * @author Trushank
 * Date Oct 9, 2012
 * Version 1.0
 *
 * 
 */

/**
 * PartialLinkedListImpl
 * 
 * @author Trushank Implements a partial linked list
 * 
 */
public class PartialLinkedListImpl implements PartialLinkedList {

    private Node start;
    private Node end;
    int size = -1;

    public PartialLinkedListImpl() {

    }

    public PartialLinkedListImpl(Object data) {
	Node n = new Node(data, null, null);
	this.start = n;
	this.end = n;

    }
public boolean clear(){
    Node n=getStart();
    while(n!=null){
	Node temp=n;
	n=n.getNext();
	temp.setData(null);
	temp.setPrevious(null);
	temp.setNext(null);

    }
    setStart(null);
    setEnd(null);
    n=null;
    return true;
}
    /**
     * add Adds Object to the end of the linked list
     * 
     * @param e
     *            Object to be added
     * @return boolean value to confirm add
     */

    @Override
    public boolean add(Object e) {
	if (getStart() == null) {
	    Node n = new Node(e, null, null);
	    setStart(n);
	    setEnd(n);
	    size++;
	    return true;
	} else {
	    Node n = new Node(e, null, end);
	    getEnd().setNext(n);
	    setEnd(n);
	    size++;
	    return true;
	}

    }

    /**
     * add Adds to the given index
     * 
     * @param index
     *            Index at which the object is to be added
     * @param element
     *            element to be added
     * 
     */
    @Override
    public void add(int index, Object element) {
	if (index > size || index < 0) {
	    throw new java.lang.IndexOutOfBoundsException("Invalid Index");
	} else {
	    Node n = start;
	    for (int i = 0; i <= index; i++) {
		n = n.getNext();
	    }
	    Node current = new Node(element, n, n.getPrevious());
	    n.getPrevious().setNext(current);
	    n.setPrevious(current);
	    size++;
	}

    }

    /**
     * addFirst add at the beginning of the linked list
     * 
     * @param e
     *            Object to be added
     */
    @Override
    public void addFirst(Object e) {

	Node n = new Node(e, getStart(), null);
	if (getStart() == null) {
	    this.end = n;
	}
	this.start = n;
	size++;

    }

    /**
     * addLast add the element to the end of the list
     * 
     * @param e
     *            element to be added
     */
    @Override
    public void addLast(Object e) {
	add(e);

    }

    /**
     * descendingIterator returns a descending Iterator of the linked list
     * 
     * @return Iterator iterator to the list
     */
    @Override
    public Iterator descendingIterator() {

	return new Iterator(this);
    }

    /**
     * 
     * getFirst gets first element in the list
     * 
     * @return element at the first position of the list
     */
    @Override
    public Object getFirst() {
	if (getStart() == null)
	    throw new java.util.NoSuchElementException("List is empty");
	return getStart().getData();
    }

    /**
     * getLast returns the last element in the list
     * 
     * @return last element in the list
     */
    @Override
    public Object getLast() {
	if (getStart() == null)
	    throw new java.util.NoSuchElementException("List is empty");
	return getEnd().getData();
    }

    /**
     * listIterator returns a list Iterator to the list
     * 
     * @return ListIterator
     */
    @Override
    public ListIterator listIterator(int index) {
	return new ListIterator(this,index);
    }

    /**
     * remove remove object from list
     * 
     * @param o
     *            object to be removed
     * @return boolean for result of remove
     */
    @Override
    public boolean remove(Object o) {
	Node current = getStart();
	if (current == null) {
	    throw new java.lang.IllegalStateException("List is empty");
	}
	
	if (getStart().getData().equals(o)) {
	    setStart(getStart().getNext());
	    getStart().setPrevious(null);
	    size--;

	    return true;
	}
	while (current.getNext() != null) {
	    if (current.getNext().getData().equals(o)) {
		current = current.getNext();
		break;
	    } else
		current = current.getNext();
	}

	if (current.getData().equals(o)) {

	    if (current.getNext() != null)
		current.getNext().setPrevious(current.getPrevious());
	    if (current.getPrevious() != null)
		current.getPrevious().setNext(current.getNext());
	    current = null;
	    size--;
	    return true;
	}

	return false;
    }

    /**
     * removeFirstOccurance removes first occurrence of the object
     * 
     * @param o
     *            the object to be removed
     * @return boolean as result of remove
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {
	return remove(o);
    }

    /**
     * removeLastOccurrence removes last occurrence of the object
     * 
     * @param o
     *            object to be removed
     * @return boolean as result of remove
     */
    @Override
    public boolean removeLastOccurrence(Object o) {
	Node current=getEnd();
	
	if(current.getData().equals(o)){
	    current.getPrevious().setNext(current.getNext());
	    current.getNext().setPrevious(current.getPrevious());
	    current=null;
	    size--;
	   
	    return true;
	}
	while(current.getPrevious()!=null){
	    if(current.getPrevious().getData().equals(o)){
		current=current.getPrevious();
		break;
	    }
	    else{
		current=current.getPrevious();
	    }
	}
	if(current.getData().equals(o)){
	    current.getPrevious().setNext(current.getNext());
	    current.getNext().setPrevious(current.getPrevious());
	    current=null;
	    size--;
	  
	    return true;
	}System.out.println("Not Found");
	return false;
	    }

    /**
     * 
     * toArray converts linked list to array
     * 
     * @return array of objects from the list
     */
    @Override
    public Object[] toArray() {
	Object[] a = new Object[size + 1];
	Node n = getStart();
	for (int i = 0; i <= size; i++) {
	    if (n == null) {
		break;
	    }
	    a[i] = n.getData();
	    n = n.getNext();
	}

	return a;
    }

    /**
     * 
     * setStart
     * 
     * @param start
     *            node to be set as start
     * @return boolean result
     */
    public boolean setStart(Node start) {
	this.start = start;
	return true;
    }

    /**
     * 
     * getStart returns start node
     * 
     * @return returns start node
     */
    public Node getStart() {
	return this.start;
    }

    /**
     * 
     * setEnd sets end node
     * 
     * @param end
     *            node to be set as end node
     * @return boolean result
     */
    public boolean setEnd(Node end) {
	this.end = end;
	return true;
    }

    /**
     * 
     * getEnd gets the last node
     * 
     * @return last node
     */
    public Node getEnd() {
	return this.end;
    }

}
