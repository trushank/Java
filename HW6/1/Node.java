/**
 * 
 * Node.java
 * Represents a node in the linked list
 * @author Trushank
 * Date Oct 14, 2012
 * Version 1.0
 *
 * 
 */

/**
 * Node
 * 
 * @author Trushank Represents a node in the linked list
 * 
 */
public class Node {
    // next node
    private Node next;
    // previous node
    private Node previous;
    private Object data;

    /**
     * Constructor
     * 
     * @param next
     *            next node
     * @param previous
     *            previous node
     * @param data
     *            data in the node
     */
    public Node(Object data, Node next, Node previous) {
	setNext(next);
	setPrevious(previous);
	setData(data);
    }

    /**
     * 
     * getNext returns node pointed by the next variable
     * 
     * @return next node
     */
    public Node getNext() {
	return this.next;
    }

    /**
     * 
     * getPrevious gets previous node
     * 
     * @return previous node
     */
    public Node getPrevious() {
	return this.previous;
    }

    /**
     * 
     * getData Returns Object stored in the node
     * 
     * @return Object stored in the node
     */
    public Object getData() {
	return this.data;
    }

    /**
     * 
     * setData sets the given object in the node
     * 
     * @param data
     *            the object to be set
     * @return
     */
    public boolean setData(Object data) {
	this.data = data;
	return true;
    }

    /**
     * 
     * setNext sets next with the passed node
     * 
     * @param next
     *            next node to be set
     * @return boolean value for result
     */
    public boolean setNext(Node next) {
	this.next = next;
	return true;
    }

    /**
     * 
     * setPrevious sets previous node to the node passed
     * 
     * @param previous
     *            previous node to be set
     * @return boolean value for result
     */
    public boolean setPrevious(Node previous) {
	this.previous = previous;
	return true;
    }
}
