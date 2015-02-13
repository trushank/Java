/**
 * Expression.java
 * Solves Equation Inputed Via Console
 * 
 * @author    Trushank Dand
 * @author	Anshika Garg
 *Version:  $Id: OsName.java,v 1.0 2012/09/12 14:15:46 tgd Exp tgd $ 
 * 
 *     
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solves Equation Inputed Via Console
 * Program assumes that inputting empty braces such as "( ( ) )" will equate to zero 
 * @author Trushank
 * @author Anshika Garg
 *
 */
public class Expression {
    private char[] operator;
    private double[] operant;
    private int operatorTos;
    private int operantTos;
    public Expression(){
	    operator= new char[10];
	    operant= new double[10];
	    operatorTos=-1;
	    operantTos=-1;
    }
public static void main(String args[]){
    InputStreamReader is=new InputStreamReader(System.in);
    BufferedReader br= new BufferedReader(is);
    
  String expression=new String();
try {
    System.out.println("Please enter the expression to be solved:\nInclude spaces between each of the values.");
    System.out.println("Example: 2 * 3 ^ 4\nPermitted Operators are +,-,*,/,^,%,(,)\nEnter Expression:");
    expression = br.readLine();
} catch (IOException e) {
  
 System.out.println("Error in Input");
}
finally{
    try {
	br.close();	//Closing inputstreams
	 is.close();
    } catch (IOException e) {
	
	e.printStackTrace();
    }
   
}
    Expression s=new Expression();
    s.makeStack(expression);

    System.out.println("Answer is: "+s.flush());
    
}
/**
 * Pushes the expressions into the stack if operator precedence is higher, else pops top of stack and computes.
 * @param String expression: The equation given by user
 */
public void makeStack(String expression){
   
    int index=0;
    String operantA=new String();	//String to store operants
    char operator;	//to store operators
    
    checkBraces(expression);	//check for pairs of braces
    
    while(index<expression.length()){
	
	operantA="";
	
	while(expression.charAt(index)==' '){ //go to next operator/operant
		index++;
	    }
	//if next char is opening brace
	if(expression.charAt(index)=='('){
	    //if next previous char after '(' is digit, add '*'
	    // example: 2 ( 3 ) ->  2 * ( 3 )
		if(index>=2 && Character.isDigit(expression.charAt(index-2))){
		    pushOperator('*');
		}
		
	    pushOperator('(');
		index++;
	    }
	//if next char is a number
	else if(Character.isDigit(expression.charAt(index))){
	    
	  //picks out operants based on spaces
	while(index<expression.length() && expression.charAt(index)!=' '){	
	    operantA=operantA+expression.charAt(index++);
    }
	
    try{
    pushOperant(Integer.parseInt(operantA));	//pushes found number into stack
    }
    catch(NumberFormatException e){
	System.out.println("Error "+operantA+ " is not a digit");
	System.exit(1);
    }
	}
	else{	//or else if next char is a operator
	    
	operator=expression.charAt(index);	//pick operator from expression
	pushOperator(operator);	//pushing operator into stack
	boolean tempCheck=expression.charAt(index)==')';
	tempCheck=tempCheck && index+2 <expression.length();
	tempCheck=tempCheck &&  (Character.isDigit(expression.charAt(index+2))|| expression.charAt(index+2)=='(');
	
    //if next char is ')' followed by a number or '(', put '*'
	//example: ( 2 ) ( 3 ) -> ( 2 ) * ( 3 )
    if( tempCheck){
	pushOperator('*');
    }
    index++;
	}
    }
}
/**
 * Computes the remaining elements left in the stack after makeStack() method
 * 
 */
public double flush(){
    while(operantTos>0){
	pushOperant(calculate(popOperant(), popOperator(), popOperant()));
    }
    System.out.println(operator[0]);
  
   if(operatorTos!=-1){	//if any operator left at the end implies error in input
       System.out.println("Wrong Input");
       System.exit(1);
   }
    return operant[0];	//Returns the final answer
}

/**
 * Pushes operator into operator stack
 * @param char newOperator
 */
public boolean pushOperator(char newOperator){
  
    if(operatorTos==-1){	//Check if operator stack is empty
	operator[++operatorTos]=newOperator;
	return true;
    }
 if(newOperator==')'){
     
     while(operator[operatorTos]!='('){
	 pushOperant(calculate(popOperant(),popOperator(),popOperant()));
     }
     operator[operatorTos--]=' ';
     return true;
 }
 else if (newOperator=='('){
     operator[++operatorTos]=newOperator;	//Put operator in array and increment Top of Stack
	return true;
 }
    
   //check priority of new operator. 
   //If less than compute every operator in stack till operator with lesser priority is encountered
   while(operatorTos>=0 && getPriority(newOperator)<getPriority(operator[operatorTos])){
       	pushOperant(calculate(popOperant(),popOperator(),popOperant()));
   }
   
   if(operatorTos>=operator.length-1){	//check if operator stack is full
	    System.out.println("Experssion too long");
	    return false;
    }else if(getPriority(newOperator)!=-1){	//Check if operator is valid (-1 implies invalid)
	operator[++operatorTos]=newOperator;	//Put operator in array and increment Top of Stack
	return true;
    }
	System.out.println("Error: Incorrect Operator");
	System.exit(1);
	return false;
    
}

/**
 * Pushes operant into operant stack
 * @param double newOperant
 */
public boolean pushOperant(double newOperant){
	if(operantTos>=operant.length-1){	//Check if operant stack is full
	    System.out.println("Experssion too long");
	    System.exit(1);
	    return false;
}
	operant[++operantTos]=newOperant;	//Put operant in operant stack
	return true;

}

/**
 * Pops operant from operant stack
 * 
 */
public double popOperant(){
    if(operantTos<0){	//if nothing in stack
	System.out.println("Error no operants found");
	System.exit(1);
	return -1;
    }else{
	double popValue=operant[operantTos];
	operant[operantTos--]=0;
	return popValue;	//return popped value
    }
}

/**
 * Pops operator from operator stack
 * 
 */
public char popOperator(){
    if(operatorTos<0){	//if nothing in stack
	System.out.println("Error no operators found");
	System.exit(1);
	return '0';
    }else{
	char popChar=operator[operatorTos];
	operator[operatorTos--]=' ';
	return popChar;	//retrun popped operator
    }
}

/**
 * Returns priority of the given operator. Example: '+'=0, '^'=3
 * @param char operator
 */
public int getPriority(char operator){
    switch(operator){
    case '(':
    case '+':
    case '-':
	return 0;
	
    case '*':
    case '/':
    case '%':
	return 1;
	
    case '^':
	return 2;
   
    case ')':
	return 3;
	default:
	    System.out.println("Error Wrong Operator");
	    System.exit(1);
	    return -1;	//return -1 for anything other than excepted inputs
    }
}

/**
 * Applies the operator to the operantA and operantB to return a double result
 * @param char[] characters Array of the characters in the Quad play
 */
public double calculate(double operantB,char operator,double operantA){
    switch(operator){
    case '+':
	return operantA+operantB;
    case '-':
	return operantA-operantB;
    case '*':
	return operantA*operantB;
    case '/':
	return operantA/operantB;
    case '%':
	return operantA%operantB;
    case '^':
	return Math.pow(operantA, operantB);
	
    default:
	System.out.println("Error Wrong Operant");
	System.exit(1);
	return 0;
    }
}
/**
 * Checks for pairs of opening and closing braces
 * @param expression: Input string
 */
private void checkBraces(String expression){
    
    int openingBraceCount=0;
    int closingBraceCount=0;
   
   for(int i=0; i<expression.length(); i++){
       if(expression.charAt(i)=='(')
	   openingBraceCount++;
       else if(expression.charAt(i)==')')
	   closingBraceCount++;
   }
   
    if(openingBraceCount!=closingBraceCount){
	System.out.println("Error: Missing Braces");
	System.exit(1);
    }
   
}
/**
 * Prints the operator and operant stack
 */
private void printStack(){
    System.out.println("*******************************");
    for(int i=0;i<operant.length;i++){
	if(operant[i]==0.0)
	    break;
	System.out.println(operant[i]+"\t"+operator[i]);
    }
}
}