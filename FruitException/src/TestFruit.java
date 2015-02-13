
public class TestFruit {
    public static void main(String args[])
    {
	//Non Exception To Show Normal Execution
	 try{
	            Apples a=new Apples("Red", 2.0, 5);	//1st apple
	            Mangos m=new Mangos("Orange", 5, 20.0);
	            Peaches p=new Peaches("Peach", 5, 20.0);
	        }catch(FruitException e){
	            System.out.println(e);
	        }
	 
	 //Weight of apples negative
	try{
	    Apples a= new Apples("red",-20.0,5.0);
	}catch(FruitException e){
	    System.out.println(e);
	}
	//Number of Man
try{
    Mangos m=new Mangos("yellow",-5,6.0);
	}catch(FruitException e){
	    System.out.println(e);
	}

//More than 5 apples
try{
    Apples a= new Apples("red",20.0,5.0);	//2nd apple
    Apples a1= new Apples("red",20.0,5.0);	//3rd apple
    Apples a2= new Apples("red",20.0,5.0);	//4th apple
    Apples a3= new Apples("red",20.0,5.0);	//5th apple
    Apples a4= new Apples("red",20.0,5.0);	//6th apple Exception
    
}catch(FruitException e){
    System.out.println(e);
}

//More than 16 peaches
try{
    Peaches p=new Peaches("peach",16,7.0);
}catch(FruitException e){
    System.out.println(e);
}

//Unit Price negative
try{
    Peaches p=new Peaches("peach",3,-7.0);
}catch(FruitException e){
    System.out.println(e);
}
        
           }

}
