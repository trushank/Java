/**
 * 
 * Matrix.java
 * @author Trushank
 * Date Oct 19, 2012
 * Version 1.0
 *
 * 
 */

/**
 * Matrix Multiplies two predefined matrices
 * 
 * @author Trushank
 * 
 */
public class Matrix implements Runnable {
    static int result[][];
    int row[];
    int col[];
    int rowNumber;
    int colNumber;

    /**
     * 
     * @param col
     *            column from mXn matrix
     * @param row
     *            row from lXm matrix
     * @param rowNumber
     *            row number fro result
     * @param colNumber
     *            column number for result
     */
    public Matrix(int row[], int col[], int rowNumber, int colNumber) {
	this.row = row;
	this.col = col;
	this.rowNumber = rowNumber;
	this.colNumber = colNumber;

    }

    /**
     * main Makes several Threads to compute multiplication of two matrices
     * 
     * @param args
     *            Not used
     */
    public static void main(String[] args) {

	// Input Matrices
	int lXm[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
	int mXn[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };

	// Initializing the result matrix to the size of lXn
	result = new int[lXm.length][mXn[0].length];

	// Checking if the matrices are compatible for multiplication
	for (int i = 0; i < lXm.length; i++) {
	    if (lXm[i].length != mXn.length) {
		System.out.println("Size mismatch Error");
		return;
	    }
	}

	// Iterating through columns
	for (int i = 0; i < lXm.length; i++) {
	    // Iterating through rows
	    for (int j = 0; j < mXn[0].length; j++) {
		// Stores the column from mXn matrix
		int temp[] = new int[mXn.length];
		// Storing jth row from mXn in temp (for multiplication later)
		for (int k = 0; k < mXn.length; k++) {
		    temp[k] = mXn[k][j];
		}
		// Creating a new object of matrix (one per element in the
		// resultant matrix)
		Matrix m = new Matrix(lXm[i], temp, i, j);
		Thread t = new Thread(m);
		t.start();
		try {
		    // Joining thread to ensure all threads finish before result
		    // is printed
		    t.join();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}
	// Printing Result

	// Iterating columns
	for (int i = 0; i < lXm.length; i++) {

	    // Going to next line after each row is printed
	    System.out.println();
	    // Iterating rows
	    for (int j = 0; j < mXn[0].length; j++) {
		System.out.print("\t" + result[i][j]);
	    }
	}
    }

    /**
     * run Implementation of the run method from Runnable interface Multiplies
     * two single dimensional arrays and stores in result array
     */
    @Override
    public void run() {
	int ans = 0;

	// Checking for compatibility of arrays
	if (row.length != col.length) {
	    System.out.println("Error in array size");
	    return;
	}
	// Multiplying arrays
	for (int i = 0; i < row.length; i++) {
	    ans = ans + (row[i] * col[i]);
	}
	// Storing result in correct position in result array
	result[rowNumber][colNumber] = ans;

    }

}
