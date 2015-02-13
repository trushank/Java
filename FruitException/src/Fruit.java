public abstract class Fruit
{	
    String color=new String();
    abstract double totalPrice();
    abstract String report();
    
    public Fruit(String color){
	this.color=color;
    }
    public String getColor(){
	return color;
    }
    /*
        */
}