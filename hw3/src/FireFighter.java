import java.util.Scanner;


public class FireFighter extends Person{
private int weight=0;
private int height=0;
public FireFighter() {
    
    if(calc_Age()<20 || calc_Age()>50){
	System.out.println("Sorry. Not eligible as a Fireman.\nExitting");
	try {
	    this.finalize();
	} catch (Throwable e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    System.exit(1);
    }
  Scanner src=new Scanner(System.in);
  System.out.println("Enter weight");
  setWeight(src.nextInt());
  System.out.println("Enter height");
  setHeight(src.nextInt());
  
}
public boolean setWeight(int weight){
    if(weight>10&&weight<1000){
    this.weight=weight;
    return true;
    }
    else return false;
}
public boolean setHeight(int height){
    if(height>100&&height<400){
	this.height=height;
	return true;
    }
    return false;
}
public int getHeight(){
    return height;
}
public int getWeight(){
    return weight;
}
public void display(){
  //  super.display();
    System.out.println("Weight of Fireman: "+getWeight());
    System.out.println("Height of Fireman: "+getHeight());
    super.display();
}
}
