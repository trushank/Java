/**
** 
* Prime.java
* @author Trushank
* Date Oct 19, 2012
* Version 1.0
 * 
 */


/**
 * @author Trushank
 *
 */
 public class Prime implements Runnable{
long input;
long milliSeconds;
    /**
     * 
     */
    public Prime(long input) {
	this.input=input;
    }

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
    
    try{
    for(int i=0;i<args.length;i++){
	Prime p=new Prime(Long.parseLong(args[i]));
	new Thread(p).start();
    }
    }catch(NumberFormatException e){
	System.out.println("Invalid Input "+e);
    }
    
    }

    /**
     * 
     */
    @Override
    public void run() {
	this.milliSeconds = System.currentTimeMillis();
	long num = this.input;
	if(this.input<0){
	    System.out.println("Sorry negative numbers not supported");
	    return;
	}
	boolean end=false;
	while (!end) {
	    int i = 2;
	    for (i = 2; i <= num / 2; i++) {

		if ((num % i) == 0) {
		
		    System.out.println("i = "+num+" not prime "+(System.currentTimeMillis()-milliSeconds)+"ms");
		    end=true;
		    break;
		}
	    }
	    if (i > num / 2) {
		 System.out.println("i = "+num+" prime "+(System.currentTimeMillis()-milliSeconds)+"ms");
		 end=true;
		 break;
	    }
	}
	
    }

}

