public class FruitException extends Exception{
    int exceptionNumber=0;
    double value=0;
    FruitException(int exceptionNumber, double value){
	this.exceptionNumber=exceptionNumber;
	this.value=value;
    }
    public String toString(){
       switch(exceptionNumber){
       case 1:
	   return "Weight of Apples can not be negative "+value;
       case 2:
	   return "Number of Mangoes can not be negative "+value;
       case 3:
	   return "Can not purchase more than 5 apples "+value;
       case 4:
	   return "Can not purchase more than 15 peaches "+value;
       case 5:
	   return "Unit price can not be negative "+value;
       default:
	   return "Unknown Error";
       }
    }
    
}