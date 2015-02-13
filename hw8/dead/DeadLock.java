/**
* 
* DeadLock.java
* @author Trushank
* Date Oct 28, 2012
* Version 1.0
* 
 */
/**
 * Conditions for deadlock: 
 * 1) Mutual Exclusion 
 * 2) Hold and wait
 * 3) Circular wait
 * 4) No preemption
 *
 */

/**
 * 
 * @author Trushank
 *
 */
 public class DeadLock implements Runnable{
static String A=new String();
static String B=new String();
String which;
    /**
     * 
     */
    public DeadLock(String which) {
	this.which=which;
	
    }
public boolean haveA(){
    synchronized (A) {
	
	try {
	    Thread.sleep(1000);
	   
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	synchronized (B) {
	    return true;
	}
	
    }
}

public boolean haveB(){
    synchronized (B) {
	synchronized (A) {
	    return false;
	}
    }
}
    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
   new Thread(new DeadLock("A")).start();
   Thread a= new Thread(new DeadLock("B"));
	a.start();
    
    }
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
	if(which.equals("A")){
	    synchronized (A) {
		  haveA();
	    }
	  
	}else{
	    synchronized (B) {
		 haveB();
	    }
	}
	   
	
    }

}

