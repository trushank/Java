/**
 * Quad.java
 * Displays all possible combinations between characters: "a","b","c". 
 * Program is generalized to accept more than 3 inputs as well.
 * 
 * @author    tgd2900
 *
 *Version:  $Id: Quad.java,v 1.0 2012/09/06 20:15:46 tgd Exp tgd $ 
 * 
 * Revisions: 
 *     
 */
public class Quad {

	/**
	 * 
	 * @param args Command line input (Not used)
	 */
	public static void main(String args[]) {
		Quad test = new Quad();
		test.printQuad(new char[] {'a', 'b', 'c'}); //calling method printQuad with arguments 'a','b','c'
	}


	/**
	 * Prints out all the powerset of the given set
	 * @param char[] characters Array of the characters in the Quad play
	 */
	void printQuad(char[] characters) {
		int max_combinations = (int) Math.pow(2, (double) characters.length); //Calculate the total number combinations

		for (int i = 0; i <= max_combinations - 1; i++) { //Iterates through each combination
			String a = new String(Integer.toBinaryString(i)); //Generate binary equivalent String of given value

			//Padding String with leading zeros if length less than required
			while (a.length() < characters.length) {
				a = "0" + a;
			}

			System.out.print("{");

			for (int j = 0; j < a.length(); j++) { //Iterates through each character of the combination

				if (a.charAt(j) == '1') {
					System.out.print(characters[j]);
				}
			}
			System.out.println("}");
		}

	}

}