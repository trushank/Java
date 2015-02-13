/**
 * 
 * PartialCollectionsImpl.java
 * @author Trushank
 * Date Oct 14, 2012
 * Version 1.0
 * /**
 * @author Trushank
 *
 */

import java.util.*;

/**
 * 
 * @author Trushank PartialCollectionsImp Implements partial collctions
 */
public class PartialCollectionsImp implements PartialCollections {
    /**
     * sort sorts a given list
     * 
     * @param PartialLinkedListImpl
     *            list to be sorted
     */
    public void sort(PartialLinkedListImpl list) {
	Object o[] = list.toArray();
	list.clear();
	for (int i = 0; i < o.length - 1; i++) {
	    for (int j = i + 1; j < o.length; j++) {
		int check = o[i].toString().compareTo(o[j].toString());
		if (check > 0) {
		    Object temp = o[i];
		    o[i] = o[j];
		    o[j] = temp;
		}
	    }
	}
	for (int i = 0; i < o.length; i++) {
	    list.add(o[i]);
	}
    }

    /**
     * sort Sorts a given list using the given comparator
     * 
     * @param list
     *            list to be sorted
     * @param c
     *            comparator to be used
     */
    public void sort(PartialLinkedListImpl list, Comparator c) {
	Object o[] = list.toArray();
	list.clear();
	for (int i = 0; i < o.length - 1; i++) {
	    for (int j = i + 1; j < o.length; j++) {

		if (c.compare(o[i], o[j]) > 0) {
		    Object temp = o[i];
		    o[i] = o[j];
		    o[j] = temp;
		}
	    }
	}
	for (int i = 0; i < o.length; i++) {
	    list.add(o[i]);
	}

    }
/**
 * shuffle
 * Shuffles the list randomly
 * @param list to be shuffled
 */
    public void shuffle(PartialLinkedListImpl list) {
	Object o[] = list.toArray();
	list.clear();
	Random r = new Random();
	for (int i = 0; i < o.length; i++) {
	    int o1 = r.nextInt(o.length);
	    Object temp = o[o1];
	    o[o1] = o[0];
	    o[0] = temp;

	}
	for (int i = 0; i < o.length; i++) {
	    list.add(o[i]);
	}
    }

}