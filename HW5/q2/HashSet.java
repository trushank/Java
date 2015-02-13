import java.util.Scanner;

/**
 * 
 * 
 * HashSet.java
 * @author Trushank
 * Date Oct 6, 2012
 * Version 1.0
 * 
 * 
 */

/**
 * HashSet implements a AnotherHashSet
 * 
 * @author Trushank
 * 
 */

public class HashSet implements AnotherHashSet {
    // size of the hashset
    private int size;
    Object hash[];
    HashSet nextH;
    HashSet previousH;
/**
 * Parameterless Constructor
 */
    public HashSet() {
	this.size = 10007;
	this.hash = new Object[this.size];
	this.nextH = null;
	this.previousH = null;
    }

    /**
     * Constructor To create first hashset
     */
    public HashSet(int size) {
	this.size = getNextPrimeNumber(size);

	this.hash = new Object[this.size];
	//System.out.println("HashSet of Size " + this.size + " created "+ hash.length);
	this.nextH = null;
	this.previousH = null;

    }

    /**
     * Constructor to create hashset after the initial one
     * 
     * @param size
     * @param previousH
     */
    public HashSet(int size, HashSet previousH) {
	this.size = size;
	hash = new Object[size];
	this.previousH = previousH;
	nextH = null;
    }

    /**
     * 
     * makeNextHash Makes another hashset of size greater than the previous one
     * 
     * @return
     */
    public HashSet makeNextHash() {
	HashSet h = this;
	while (h.nextH != null) {
	    h = h.nextH;
	}

	h.nextH = new HashSet(getNextPrimeNumber(h.size), h);
	return h.nextH;
    }

    public int getNextPrimeNumber(int oldPrime) {
	int num = oldPrime + 2;
	while (true) {
	    int i = 2;
	    for (i = 2; i <= num / 2; i++) {

		if ((num % i) == 0) {
		    num += 2;
		    continue;
		}
	    }
	    if (i > num / 2) {
		return num;
	    }
	}
    }

    /**
     * 
     * add
     * 
     * @param o
     * @return
     */

    @Override
    public boolean add(Object o) {

	// if object already present in the hashset
	if (contains(o)) {
	    //System.out.println("Object already exists in HashSet");
	    return false;
	}
	// if space found in the current hashset
	else {
	    int index = o.hashCode() % size;
	    if(o.hashCode()<0){
		
		    index=(o.hashCode()*-1)%size;
	    }

	    // System.out.println("Hashcode: " + o.hashCode() + "\nSize: " +
	    // size);
	    if (this.hash[index] == null) {
		this.hash[index] = o;
		//System.out.println("Successfully Added at " + index);
		return true;
	    }
	    // Making new hashset
	    else {
		//System.out.println("Collision");
		if (this.nextH == null) {
		    return makeNextHash().add(o);
		} else {
		    return this.nextH.add(o);
		}

	    }

	}

    }

    /**
     * 
     * clear Deletes extra hashsets and removes Objects from current hashset
     */
    @Override
    public void clear() {

	// Deleting the other hash tables
	if (this.nextH != null) {
	    HashSet del = this.nextH;
	    while (del.nextH != null) {
		HashSet nextDel = del.nextH;
		try {
		    del.finalize();
		} catch (Throwable e) {
		    e.printStackTrace();
		}
		del = nextDel;
	    }
	}
	// Removing elements from first hash table
	for (int i = 0; i < this.size; i++) {
	    hash[i] = null;
	}
	this.nextH = null;
	//System.out.println("Hashset Cleared");
    }

    /**
     * 
     * contains Checks if the hashset contains the given object
     * 
     * @param o
     * @return
     */
    @Override
    public boolean contains(Object o) {

	HashSet h = this;
	int hashCode = o.hashCode();
if(hashCode<0){
    hashCode=hashCode*-1;
}
	while (h != null) {

	    int index = hashCode % h.size;

	    if (h.hash[index] != null && h.hash[index].equals(o)) {
		// System.out.println("Object found");
		return true;
	    } else {

		h = h.nextH;
	    }
	}
	// System.out.println("Object not found");
	return false;
    }

    /**
     * 
     * isEmpty Checks if HashSet is Empty
     * 
     * @return
     */
    @Override
    public boolean isEmpty() {
	HashSet h1 = this;
	while (h1 != null) {
	    for (int i = 0; i < h1.size; i++) {
		if (h1.hash[i] != null) {
		   // System.out.println("HashSet contains elements");
		    return false;
		}
	    }
	    h1 = h1.nextH;
	}
	//System.out.println("HashSet does not contain elements");
	return true;
    }

    /**
     * 
     * remove removes passed object from hashset
     * 
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {

	if (contains(o)) {
	    int hash = o.hashCode();
	    if(hash<0){
		
		    hash=hash*-1;
	    }
	    HashSet h = this;
	    while (h != null) {
		if (h.hash[hash % h.size].equals(o)) {
		    break;
		}
	    }
	    while (h.nextH != null) {
		int index = hash % h.size;
		h.hash[index] = null;
		if (h.nextH.hash[hash % h.nextH.size] != null) {
		    h.hash[index] = h.nextH.hash[hash % h.nextH.size];
		}
		h = h.nextH;

	    }
	    h.hash[hash % h.size] = null;
	    //System.out.println("Object removed");
	    return true;
	} else {
	    //System.out.println("Object does not exist");
	    return false;
	}
    }

    /**
     * 
     * getSize: Returns size of the hashset
     * 
     * @return
     */
    @Override
    public int size() {

	int size = 0;
	HashSet h = this;
	while (h != null) {
	    for (int i = 0; i < h.size; i++) {
		if (h.hash[i] != null) {
		    size++;
		}
	    }
	    h = h.nextH;
	}
	return size;
    }

    /**
     * 
     * print Prints the hashsets divided by *s
     */
    public void print() {
	HashSet h = this;
	while (h != null) {
	    System.out.println("*************************************");
	    for (int i = 0; i < h.size; i++) {
		if (h.hash[i] != null) {
		    System.out.println(h.hash[i]);
		}
	    }
	    h = h.nextH;
	}
    }

}
