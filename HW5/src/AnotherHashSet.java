/**
 * AnotherHashSet.java
 * Interface with a template of all methods required in the hashset
 * @author Trushank
 * @date Oct 6, 2012
 * @version 1.0
 * 
 */

/**
 * @author Trushank Interface containing all the methods required in the hashset
 */
public interface AnotherHashSet {

    /**
     * 
     * add to add object to the hashset
     * 
     * @param o
     * @return
     */
    public boolean add(Object o);

    /**
     * 
     * clear to empty the hashset
     */
    public void clear();

    /**
     * 
     * contains to check if hashset contains the passed object
     * 
     * @param o
     * @return
     */
    public boolean contains(Object o);

    /**
     * 
     * isEmpty checks if hashset is empty
     * 
     * @return
     */
    public boolean isEmpty();

    /**
     * 
     * remove removes passed value from the hashset
     * 
     * @param o
     * @return
     */
    public boolean remove(Object o);

    /**
     * 
     * size returns number of elements in the hashset (Cardinality)
     * 
     * @return
     */
    public int size();
}