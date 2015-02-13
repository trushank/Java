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
 public class DeadLock {
static String A=new String();
static String B=new String();
String which;
    /**
     * 
     */
    public DeadLock(String which) {
	this.which=which;
	
    }
public static synchronized boolean haveA(DeadLock a){
   haveB(a);
	return true;
	
}

public static synchronized boolean haveB(DeadLock b){
   haveA(b);
    return true;
}
    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
	final DeadLock a=new DeadLock("A");
	final DeadLock b=new DeadLock("B");
	
   Thread t1=new Thread(new Runnable() {
       public void run() { haveA(b); }
   });
   Thread t2=new Thread(new Runnable() {
       public void run() { haveB(a); }
   });
   t1.start();
   t2.start();
  
    }
   
}

