import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

/**
 * 
 * MyFrame.java
 * Extends JFrame to make the custom board
 * @author Trushank
 * Date Nov 2, 2012
 * Version 1.0
 * 
 * 
 */
/**
 * @author Trushank MyFrame extends JFrame to make the custom board
 */
public class MyFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    MyFrame other; // Reference to other players frame
    JPanel grid = new JPanel(); // Panel to hold the grid of buttons
    JPanel dials = new JPanel(); // Panel to hold the options
    MyButton b[][] = new MyButton[11][11]; // Array of buttons
    JButton start = new JButton("Start"); // Start button
    JRadioButton horizontal = new JRadioButton("Horizontal"); // Horizontal
							      // selector
    JRadioButton vertical = new JRadioButton("Vertical"); // Veritical selector
    ButtonGroup bgroup = new ButtonGroup(); // Button group for selectors
    JLabel msg = new JLabel(); // Info msg
    int shipSize = 5;
    boolean started = false;
    int points = 0;

    /**
     * Constructor
     * 
     * @param title
     *            Title of the Frame
     */
    public MyFrame(String title) {
	super(title); // calling super constructor
	makeGUI(); // making the GUI
    }

    /**
     * 
     * makeGUI Makes the GUI
     */
    public void makeGUI() {
	dials.setLayout(new FlowLayout());
	grid.setLayout(new GridLayout(12, 11));
	setLayout(new FlowLayout());
	bgroup.add(horizontal);
	bgroup.add(vertical);
	horizontal.setSelected(true);

	// Adding buttons
	for (int i = 0; i < 11; i++) {
	    for (int j = 0; j < 11; j++) {
		b[i][j] = new MyButton(i, j);
		if (i == 0) {
		    b[i][j].setText(Integer.toString(j));
		    b[i][j].setEnabled(false);
		}
		if (j == 0) {
		    b[i][j].setText(Integer.toString(i));
		    b[i][j].setEnabled(false);
		}
		grid.add(b[i][j]);

		b[i][j].setBackground(Color.cyan);

		b[i][j].addActionListener(new Pressed(this));

		b[0][0].setText("");

	    }
	}
	msg.setText("Select 5 row ship");

	// adding to options frame
	dials.add(horizontal);
	dials.add(vertical);
	dials.add(start);
	dials.add(msg);

	// adding to frame
	add(grid);
	add(dials);

	pack();

	setSize(600, 450);
	setVisible(true);
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	// defining start buttons action
	start.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		if (shipSize <= 1) {
		    started = true;
		    msg.setText("Play");
		    start.setEnabled(false);
		    swap();
		}

	    }
	});
    }

    /**
     * 
     * swap Switches the turn of the player
     */
    public void swap() {
	if (other != null) {
	    this.setVisible(false);
	    other.setVisible(true);
	}
    }
}
