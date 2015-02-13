/**
 * WordCount.java
 * Counts Number of words in the file
 * Considers numbers as words.
 * Considers things separated by "-" or "'" as one word
 * Looks for words and not for delimiters.
 * 
 * @author    Trushank Dand
 * @author	Anshika Garg
 *Version:  $Id: CashRegister.java,v 1.0 2012/09/23 16:15:46 tgd Exp tgd $ 
 * 
 *     
 */
import java.io.File;
import java.util.Scanner;
/** 
 * class WordCount
 * Counts number of words in the file
 * 
 * @author      Trushank Dend
 * @id          tgd2900
 *
 * @author      Anshika Garg 
 * @id          axg3637
 */
class WordCount {
    /**
     * main: Counts number of words in the file
     * @param args: args[0]:Input file name
     */
    public static void main(String args[]) {
        //Alphabet for determining word
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        alphabet += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabet += "0123456789";
        //word counter
        int counter = 0;
        Scanner src; //Scanner to read file
        try {
            src = new Scanner(new File(args[0]));
            //Traverse file line by line
            while (src.hasNextLine()) {
                String temp = src.nextLine();
                boolean word_Start = false;
                //Traverse Line char by char
                for (int i = 0; i < temp.length(); i++) {
                    //check if char is a part of alphabet
                    if (alphabet.indexOf(temp.charAt(i)) != -1) {
                        word_Start = true; //consider word to have started
                    } else if (word_Start) {
                        //check for 's or peer-to-peer (i.e. "'" and "-"
                        if (temp.charAt(i) == '\'' || temp.charAt(i) == '-') 
                            if (alphabet.indexOf(temp.charAt(i + 1)) != -1) 
                        	continue;
                        word_Start = false; //consider word to have finished
                        counter++; //increment counter at end of word
                    }
                }
            }
            System.out.println("Number of words in the file: " + counter); //printing output
            src.close(); //Freeing resources
        } catch (Exception e) {
            System.out.println("Please Pass file name as commandline and try again");
            e.printStackTrace();
        }
    }
}