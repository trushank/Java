import javax.swing.JButton;

/**
 * 
 * MyButton.java
 * Extends JButton to provide x, y info
 * @author Trushank
 * Date Nov 2, 2012
 * Version 1.0
 *
 */

/**
 * @author Trushank 
 * MyButton extends JButton to provide x,y info
 */
public class MyButton extends JButton {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    int x;
    int y;

    /**
     * 
     * @param x
     *            x-position in array
     * @param y
     *            y-position in array
     */
    public MyButton(int x, int y) {
	super();
	this.x = x;
	this.y = y;
    }

}
