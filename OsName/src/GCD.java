/**
GCD.java
@author Trunk
Date: Sep 14, 2013
 */
public class GCD {
public static void main(String args[]){
    
}
static long gcd(long a, long b)
{
  if(a == 0 || b == 0) return a+b; // base case
  return gcd(b,a%b);
}
}

