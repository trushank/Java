class Peaches extends Fruit
{
   
    private int number;
    private double priceEach;

        public Peaches(String color, int number, double priceEach) throws FruitException
        {
            super(color);
        this.number=number;
        this.priceEach=priceEach;
 
           
        }
        public double getPrice()
        {
            return priceEach;
        }

      
        public int getNumber(){
            
            return number;
        }
        public String report()
        {
            return ("I bought "+getColor()+" peaches.");
        }

        public double totalPrice()
        {
            return (number*priceEach);
        }
    

}
