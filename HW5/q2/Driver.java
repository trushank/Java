/**
 * Driver.java
 * Tests HashSet
 * @author Trushank
 * @Version 1.0
 * @Date 10/07/2012
 */

/**
 * class Driver Tests HashSet
 * 
 * @author Trushank
 * 
 */
public class Driver {
    static long milliSeconds;
    // Self Implemented HashSet
    // HashSet h1;

    // Java Util Hashset
    @SuppressWarnings("rawtypes")
    java.util.HashSet h1;
    final int MAX_ELEMENTS = 10000;

    @SuppressWarnings("rawtypes")
    Driver() {
	milliSeconds = System.currentTimeMillis();
	// h1=new HashSet();
	h1 = new java.util.HashSet();
    }

    /**
     * 
     * main Uses driver class to test effeciency of HashSets
     * 
     * @param args
     */
    public static void main(String args[]) {
	Driver d = new Driver();
	d.addTest();
	System.out.println("Add Test: "
		+ (System.currentTimeMillis() - milliSeconds));
	milliSeconds = System.currentTimeMillis();
	d.containsTest();
	System.out.println("Contains Test: "
		+ (System.currentTimeMillis() - milliSeconds));
	milliSeconds = System.currentTimeMillis();
	d.sizeTest();
	System.out.println("Size Test: "
		+ (System.currentTimeMillis() - milliSeconds));
	milliSeconds = System.currentTimeMillis();
	d.isEmptyTest();
	System.out.println("Is Empty Test: "
		+ (System.currentTimeMillis() - milliSeconds));
	milliSeconds = System.currentTimeMillis();
	d.removeTest();
	System.out.println("Remove Test: "
		+ (System.currentTimeMillis() - milliSeconds));
	milliSeconds = System.currentTimeMillis();

    }

    /**
     * 
     * addTest Tests add method
     */
    @SuppressWarnings("unchecked")
    public void addTest() {
	for (int i = 0; i < MAX_ELEMENTS; i++) {
	    h1.add(new Integer(i));
	}
    }

    /**
     * 
     * containsTest Tests Contain method
     */
    public void containsTest() {
	for (int i = 100; i < MAX_ELEMENTS + 100; i++) {
	    h1.contains(new Integer(i));
	}
    }

    /**
     * 
     * sizeTest Tests size method
     */
    public void sizeTest() {
	for (int index = 0; index < MAX_ELEMENTS; index++) {
	    if (h1.size() != MAX_ELEMENTS)
		System.out.println("size: " + index + " failed ");
	}
    }

    /**
     * 
     * isEmptyTest Tests is Empty method
     */
    public void isEmptyTest() {
	for (int index = 0; index < MAX_ELEMENTS; index++) {
	    h1.isEmpty();
	}
    }

    /**
     * 
     * removeTest Test remove method
     */
    public void removeTest() {
	for (int index = 0; index < MAX_ELEMENTS; index++) {
	    h1.remove(new Integer(index));
	}
    }
}