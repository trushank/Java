import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

/**
* 
* NumberGenerator.java
* @author Trushank
* Date Nov 30, 2012
* Version 1.0
* 
 */
/**
 * @author Trushank
 *
 */
public class NumberGenerator {

   

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
 int n=10;
 
 try{
 PrintWriter ten=new PrintWriter(new File("ten.txt"));
 PrintWriter hundred=new PrintWriter(new File("hundred.txt"));
 PrintWriter thousand=new PrintWriter(new File("thousand.txt"));
 PrintWriter tenThousand=new PrintWriter(new File("tenThousand.txt"));
 PrintWriter lakh=new PrintWriter(new File("lakh.txt"));
 Random r=new Random(System.currentTimeMillis());
 
 
 
 
 long z = ((n*n)-1) + 1;
 for(int i=0;i<n;i++){
     long a=r.nextLong() % z;
     if(a<0){
	 a=-a;
     }
     ten.write(Long.toString(a)+"\t");
 }
 n=100;
 z = ((n*n)-1) + 1;
 for(int i=0;i<n;i++){
     long a=r.nextLong() % z;
     if(a<0){
	 a=-a;
     }
     hundred.write(Long.toString(a)+"\t");
 }
 n=1000;
 z = ((n*n)-1) + 1;
 for(int i=0;i<n;i++){
     long a=r.nextLong() % z;
     if(a<0){
	 a=-a;
     }
     thousand.write(Long.toString(a)+"\t");
 }
 n=10000;
 z = ((n*n)-1) + 1;
 for(int i=0;i<n;i++){
     long a=r.nextLong() % z;
     if(a<0){
	 a=-a;
     }
     tenThousand.write(Long.toString(a)+"\t");
 }
 n=100000;
 z = ((n*n)-1) + 1;
 for(int i=0;i<n;i++){
     long a=r.nextLong() % z;
     if(a<0){
	 a=-a;
     }
     lakh.write(Long.toString(a)+"\t");
 }
 ten.close();
 hundred.close();
 thousand.close();
 tenThousand.close();
 lakh.close();
 }catch(IOException e){
     
 }
    }
}