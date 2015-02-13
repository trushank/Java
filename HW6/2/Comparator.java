/**
* 
* Comparator.java
* Implements a comparator interface
* @author Trushank
* Date Oct 14, 2012
* Version 1.0
*
 */

 /**
 * @author Trushank
 * Comparator
 * Implements comparator interface
 */
public class Comparator implements java.util.Comparator<Object>{

    /**
     * compare
     * Compares two objects
     * @param o1 object 1
     * @param o2 object 2
     * @return int specifying greater smaller or equal
     */
    @Override
    public int compare(Object o1, Object o2) {
	int check=o1.toString().compareTo(o2.toString());
	return check;
    }

}

