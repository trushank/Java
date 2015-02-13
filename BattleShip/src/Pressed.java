import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * * 
 * Pressed.java
 * @author Trushank
 * Date Nov 2, 2012
 * Version 1.0
 *  
 */
/**
 * @author Trushank
 * 
 */
class Pressed implements ActionListener {
    MyFrame f;

    public Pressed(MyFrame f) {
	this.f = f;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	MyButton b = (MyButton) e.getSource();
	int x = b.x;
	int y = b.y;

	if (f.started) {
	    if (!f.other.b[x][y].getBackground().equals(Color.cyan)) {
		f.other.b[x][y].setBackground(Color.cyan);
		b.setText("X");
		f.points++;
		if (f.points >= 14) {
		    f.msg.setText("You Win");
		} else
		    f.swap();
	    } else {
		b.setText("-");
		f.swap();
	    }
	    b.setEnabled(false);
	} else {

	    if (f.horizontal.isSelected() && f.shipSize > 1) {
		addHorizontal(b.x, b.y);
	    } else if (f.vertical.isSelected() && f.shipSize > 1) {
		addVertical(b.x, b.y);

	    }
	}
    }

    /**
     * 
     * addHorizontal: Adds ships horizontally
     * 
     * @param a
     *            : x position
     * @param b
     *            : y position
     */
    public void addHorizontal(int a, int b) {
	int x = a;
	int y = b;
	if (y + f.shipSize <= 11) {
	    for (int i = 0; i < f.shipSize; i++) {
		if (f.b[x][y++].getBackground() != Color.cyan) {
		    f.msg.setText("Not enough space");
		    return;
		}
	    }
	    x = a;
	    y = b;

	    switch (f.shipSize) {
	    case 5:
		for (int i = 0; i < f.shipSize; i++)
		    f.b[x][y++].setBackground(Color.white);
		break;
	    case 4:
		for (int i = 0; i < f.shipSize; i++)
		    f.b[x][y++].setBackground(Color.red);
		break;
	    case 3:
		for (int i = 0; i < f.shipSize; i++)
		    f.b[x][y++].setBackground(Color.yellow);
		break;
	    case 2:
		for (int i = 0; i < f.shipSize; i++)
		    f.b[x][y++].setBackground(Color.green);
		break;

	    }
	    f.shipSize--;
	    if (f.shipSize > 1) {
		f.msg.setText("Select " + f.shipSize + " row ship");
	    } else {
		f.msg.setText("Select start to continue");
	    }

	} else {
	    f.msg.setText("Not enough space");
	}
    }

    /**
     * 
     * addVertical: Adds ships vertically
     * 
     * @param a
     *            : X position
     * @param b
     *            : Y position
     */
    public void addVertical(int a, int b) {
	int x = a;
	int y = b;
	if (x + f.shipSize <= 11) {
	    for (int i = 0; i < f.shipSize; i++) {
		if (f.b[x++][y].getBackground() != Color.cyan) {
		    f.msg.setText("Not enough space");
		    return;
		}

	    }
	    x = a;
	    y = b;

	    switch (f.shipSize) {
	    case 5:
		for (int i = 0; i < f.shipSize; i++)
		    f.b[x++][y].setBackground(Color.white);
		break;
	    case 4:
		for (int i = 0; i < f.shipSize; i++)
		    f.b[x++][y].setBackground(Color.red);
		break;
	    case 3:
		for (int i = 0; i < f.shipSize; i++)
		    f.b[x++][y].setBackground(Color.yellow);
		break;
	    case 2:
		for (int i = 0; i < f.shipSize; i++)
		    f.b[x++][y].setBackground(Color.green);
		break;

	    }
	    f.shipSize--;
	    if (f.shipSize > 1) {
		f.msg.setText("Select " + f.shipSize + " row ship");
	    } else {
		f.msg.setText("Select start to continue");
	    }

	} else {
	    f.msg.setText("Not enough space");

	}

    }
}
