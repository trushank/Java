

/**
 * 
 * PartialLinkedList.java
 * @author Trushank
 * Date Oct 9, 2012
 * Version 1.0
 * 
 */

/**
 * PartialLinkedList
 * @author Trushank
 * 
 */
public interface PartialLinkedList {
    boolean add(Object e);

    void add(int index, Object element);

    void addFirst(Object e);

    void addLast(Object e);

    Iterator descendingIterator();

    Object getFirst();

    Object getLast();

    ListIterator listIterator(int index);

    boolean remove(Object o);

    boolean removeFirstOccurrence(Object o);

    boolean removeLastOccurrence(Object o);

    Object[] toArray();
}