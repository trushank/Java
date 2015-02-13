/**
 * 
 * BattleShip.java
 * Starts the game
 * 
 * 
 * RULES:
 * 1) Players set their 5,4,3,2 ships at the start
 * 2) On attacking, if "hit" then "X" is placed on 
 *    their board and the part of ship is sunk on the opponents board
 * 3) If "miss" then "-" is marked on players board
 * 4) When either player sinks all ships, he/she wins
 * 
 * @author Trushank
 * Date Oct 30, 2012
 * Version 1.0
 * 
 */
/**
 * @author Trushank Starts the game
 */
public class BattleShip {

    /**
     * Default constructor Starts game
     */
    public BattleShip() {

	MyFrame player1 = new MyFrame("Player1");
	MyFrame player2 = new MyFrame("Player2");
	player1.other = player2;
	player2.other = player1;
	player2.setVisible(false);
    }

    /**
     * main
     * 
     * @param args
     *            : not used
     */
    public static void main(String[] args) {
	new BattleShip(); // starting game

    }
}
