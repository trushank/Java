import java.util.Random;
import java.util.Vector;

/**
 * 
 * NotHealthy.java
 * @author Trushank
 * Date Oct 19, 2012
 * Version 1.0
 *
 */
/**
 * @author Trushank
 * 
 */
public class NotHealthy implements Runnable {

    static Vector<String> in; // Synchronized object
    static int times = 10; // Number of times produced (Max 10)
    // 0=paper 1=tobacco 2=matches
    String has = new String(); // Ingredients owned by smoker (m=Matches p=Paper
			       // etc)
    boolean agent = false; // Is thread a agent
    String[] names = { "Paper", "Tobacco", "Matches" }; // String representation
							// of codes 0,1,2
    String[] values = { "p", "t", "m" }; // abbreviation of 0,1,2

    /**
     * Smoker constructor
     * 
     * @param has
     *            what it has
     * @param ing
     *            synchrozing vector
     */
    public NotHealthy(String has, Vector<String> ing) {
	if (has.length() == 1) {
	    this.has = has;
	    in = ing;

	}
    }

    /**
     * Agent constructor
     * 
     * @param agent
     *            is thread a agent
     * @param ing
     *            synchronizing vector
     */
    public NotHealthy(boolean agent, Vector<String> ing) {
	if (agent) {
	    this.agent = agent;
	    in = ing;
	} else
	    System.out.println("Wrong input in agent constructor");
    }

    /**
     * 
     * needs returns abbreviation of two items needed
     * 
     * @return String containing abbreviation of items needed
     */
    public String needs() {
	if (has.length() != 1) {
	    System.out.println("Error in needs: Has");
	    return "Error";
	}
	String need = new String();

	if (!has.equals("p")) {
	    need += "p";
	}
	if (!has.equals("t")) {
	    need += "t";
	}
	if (!has.equals("m")) {
	    need += "m";
	}
	need = sort(need);
	if (need.length() == 2)
	    return need;
	else {
	    System.out.println("Error in needs");
	    return "Error";
	}
    }

    /**
     * 
     * sort sorts alphabetically eg:pm>mp
     * 
     * @param a
     *            String to be sorted
     * @return sorted string
     */
    public String sort(String a) {

	if (a.length() == 2) {
	    if (a.equals("pm"))
		return "mp";
	    if (a.equals("tm"))
		return "mt";
	    if (a.equals("tp"))
		return "pt";
	    return a;
	} else {
	    System.out.println("Error in sort");
	    return "Error";
	}
    }

    /**
     * Checks if needed items are available available
     * 
     * @param need
     *            abbreviated string of needed items
     * @return is available
     */
    public boolean available(String need) {
	// System.out.println("Checking for "+need);
	need = sort(need);
	if (!in.isEmpty()) {
	    in.set(0, sort(in.elementAt(0)));
	    if (in.elementAt(0).contains(need)) {
		return true;
	    }
	}
	return false;
    }// available ends

    /**
     * Shows readable names of the abbreviated items showName
     * 
     * @param a
     *            abrreviated items
     * @return Readable names
     */
    public String showName(String a) {
	a = sort(a);
	if (a.length() == 2) {
	    if (a.equals("mp"))
		return "Paper and Matches";
	    if (a.equals("mt"))
		return "Matches and Tobacco";
	    if (a.equals("pt"))
		return "Paper and Tobacco";
	    System.out.println("Error in showName");
	    return "Error";
	} else {
	    System.out.println("Error in showName");
	    return "Error";
	}
    }// showname ends

    /**
     * main Makes 4 threads and starts them
     * 
     * @param args
     *            not used
     */
    public static void main(String[] args) {
	in = new Vector<String>();
	NotHealthy smoker1 = new NotHealthy("m", in); // needs paper and tobacco
	NotHealthy smoker2 = new NotHealthy("p", in); // needs tobacco and
						      // matches
	NotHealthy smoker3 = new NotHealthy("t", in); // needs matches and paper
	NotHealthy producer = new NotHealthy(true, in);

	// Starting threads
	new Thread(producer).start();
	new Thread(smoker1).start();
	new Thread(smoker2).start();
	new Thread(smoker3).start();

    }// main ends

    /**
     * Produces the items for smoking (two at a time) produce
     */
    public void produce() {
	// System.out.println("Agent Entered");

	// Wait till vector is empty
	while (!in.isEmpty()&&times>0) {
	    try {
		System.out.println("Stock full. Waiting");
		in.wait(10000);
	    } catch (Exception e) {

		System.out.println(e);
	    }
	}
	// Once empty produce two random items
	if (in.isEmpty()) {
	    Random r = new Random(System.currentTimeMillis());
	    int a = r.nextInt(3);
	    int b = r.nextInt(3);

	    while (b == a)
		b = r.nextInt(3);

	    in.clear();
	    in.add(sort(new String(values[a] + values[b])));
	    System.out.println(names[a] + " and " + names[b] + " produced");
	    in.notifyAll(); // notify of new items
	    try {
		// Thread.sleep(1000);
		in.wait(10000);; // wait till item is consumed

	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }// produce ends

    /**
     * Consumes the items produced if available consume
     */
    public void consume() {
	// System.out.println(showName(needs()) + " Entered");

	// Wait till item is available or vector is empty
	while (in.isEmpty() && !available(needs())&& times>0) {
	    try {
		// System.out.println(showName(needs())+ " waiting");
		in.wait(10000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}

	// If items available: Consume
	if (available(needs())) {
	    System.out.println(showName(needs()) + " consumed");
	    times--;
	    in.clear();
	    in.notifyAll(); // Notify of consumption
	    try {
		// Thread.sleep(1000);
		in.wait(10000); // wait till new item produced
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }// consume ends

    /**
     * run Implementation of run from the Runnable interface Allows 10 cigrettes
     * to be smoked
     */
    @Override
    public void run() {

	while (times != 0) {
	    synchronized (in) {
		if (agent)
		    produce(); // produces items
		else
		    consume(); // consumes items
		
	    }// synchronized ends
	}// while ends
	
    }// run ends
}// class ends
