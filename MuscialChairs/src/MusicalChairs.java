import java.util.Random;

/**
 * 
 * MusicalChairs.java
 * @author Trushank
 * Date Oct 28, 2012
 * Version 1.0
 * 
 */
/**
 * Main class that starts all the threads
 * 
 * @author Trushank
 * 
 */
public class MusicalChairs {
    static Seat[] seats;
    static Child children[];
    static Boolean musicPlaying = true;
    static Boolean musicPlaying1 = true;
    static boolean full = false;

    /**
     * Constructor that takes the number of players-1
     * 
     * @param size
     *            number of players-1
     */
    public MusicalChairs(int size) {
	seats = new Seat[size];
	for (int i = 0; i < size; i++) {
	    seats[i] = new Seat();
	}
    }

    /**
     * 
     * ready checks if all the seats have been occupied
     * 
     * @param state
     * @return boolean value for result
     */
    public boolean ready(int state) {

	for (int i = 0; i < seats.length; i++) {
	    if (!seats[i].isOccupied())
		return false;
	}

	return true;

    }

    /**
     * main
     * 
     * @param args
     *            number of players
     */
    public static void main(String[] args) {
	try {
	    int number = Integer.parseInt(args[0]);
	    MusicalChairs c = new MusicalChairs(number - 1);
	    children = new Child[number];
	    for (int i = 0; i < children.length; i++) {
		children[i] = c.new Child(i);
	    }
	    Judge j = c.new Judge();
	    Thread judge = new Thread(j);
	    judge.start();
	    for (int i = 0; i < number; i++)
		new Thread(children[i]).start();
	    // judge.join();
	    // System.out.println("Winner is "+children[0]);
	} catch (Exception e) {

	}

    }

    /**
     * Unoccupies the chairs and reduces them by one if only one left, it
     * declares the winner resetChairs
     */
    public void resetChairs() {
	musicPlaying = true;
	full = false;

	int size = seats.length - 1;
	seats = new Seat[size];
	for (int i = 0; i < size; i++) {
	    seats[i] = new Seat();
	}

	for (int i = 0; i < children.length; i++) {
	    children[i].seated = false;
	}
	Child temp[] = new Child[seats.length + 1];
	int index = 0;
	for (int i = 0; i < children.length; i++) {
	    if (children[i].playing) {
		try {
		    temp[index++] = children[i];
		} catch (Exception e) {
		}
	    }

	}
	children = temp;
	System.out.print("===");
	for (int i = 0; i < children.length; i++)
	    System.out.print(children[i].id + " ");
	System.out.println();
	if (size == 1) {
	    System.out.println("Ok, and the winner is:" + children[0].id);
	}
    }

    /**
     * Simulates children dancing around the chair dance
     */
    public synchronized void dance() {
	Child temp;
	Random r = new Random();
	for (int i = 0; i < children.length; i++) {
	    int ran = r.nextInt(children.length - 1);
	    temp = children[ran];
	    children[ran] = children[0];
	    children[0] = temp;
	}

    }

    /**
     * Judge: Acts as a judge to the game. Starts and stops the music
     * 
     * @author Trushank
     * 
     */
    public class Judge implements Runnable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

	    while (seats.length != 1) {
		synchronized (musicPlaying1) {

		    Random r = new Random();
		    int time = r.nextInt(20);
		    musicPlaying = true;
		    while (time-- > 0) {
			dance();
		    }
		    System.out.println((children.length - 1) + " are playing");

		    musicPlaying = false;
		    musicPlaying1.notifyAll();

		    try {
			while (!ready(1)) {
			    musicPlaying1.notifyAll();
			    musicPlaying1.wait();
			}
			resetChairs();
		    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		}
	    }
	}

    }

    /**
     * Simulates the children
     * 
     * @author Trushank
     * 
     */
    public class Child implements Runnable {
	int id;

	boolean playing = true;
	boolean seated = false;
	Random r = new Random();

	public Child(int id) {
	    this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
	    while (seats.length != 1 && playing) {
		synchronized (musicPlaying1) {
		    try {
			while (musicPlaying || seated) {
			    dance();
			    musicPlaying1.notifyAll();
			    musicPlaying1.wait();
			}
		    } catch (InterruptedException e) {

			e.printStackTrace();
		    }

		    if (!full) {
			for (int i = 0; i < children.length; i++) {

			    if (i <= seats.length - 1) {
				seats[i].occupy(children[i]);
				// System.out.println("Seat "+i+" occupied by "+children[i].id);
				musicPlaying1.notifyAll();

			    } else {
				System.out.println("\t\t" + children[i].id
					+ " is out");
				children[i].playing = false;

			    }
			}
			full = true;
		    }

		}

	    }
	}

    }

    /**
     * Simulates the chairs
     * 
     * @author Trushank
     * 
     */
    public class Seat {
	boolean empty = true;
	Child c;

	public synchronized void occupy(Child c) {
	    if (empty && !c.seated) {
		this.c = c;
		empty = false;
		c.seated = true;
	    } else if (c.seated) {
		System.out.println(c.id + " already has chair");
	    } else if (!empty) {
		System.out.println("Seat is taken");
	    }

	}

	/**
	 * Finds if the seat is taken isOccupied
	 * 
	 * @return if seat is occupied or not
	 */
	public synchronized boolean isOccupied() {
	    return !empty;
	}

    }

}
