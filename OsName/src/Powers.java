
/**
Powers.java
@author Trunk
Date: Sep 14, 2013
 */
public class Powers {
    public static void main(String args[]){
	boolean found=false;
	String primitive="";
	long pow=21;
	long order=1;
	for(long i=1;i<pow;i++){
	    long res=1;
	    System.out.print(res+"\t");
	    for(long j=1;j<pow;j++){
		res=res*i%pow;
		if(!found){
		if(res!=1)
		    order++;
		else
		    found=true;
		}
//		if(i==4 && res==3) System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.print(res+"\t");
	    }
	    if(order!=pow)
	    System.out.println("#"+order);
	    else
		System.out.println("#"+gcd(i,pow)+"(gcd)");
	    if(order==20)
		primitive=primitive+" "+i;
	    order=1;
	    found=false;
	}
	System.out.println(primitive);
    }
    static long gcd(long a, long b)
    {
      if(a == 0 || b == 0) return a+b; // base case
      return gcd(b,a%b);
    }
}

