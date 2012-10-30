import java.awt.Dimension;

import javax.swing.JFrame;

/** Class to run the CalculatorScreenPanel and BinaryOperations classes
 * Extra Credit:  
 * If an error comes up (negative number/divide by zero, there will be an pop-up error message
 * The NOT, AND, OR, and XOR operations have been added to the calculator
 * @author Jared Moore
 * @version 10/17/12
 */
public class HW6Driver {

	/** Main method, run the programs
	 * @param args - unused
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Binary Calculator");
		CalculatorScreenPanel panel = new CalculatorScreenPanel();
		frame.add(panel);
		frame.setMinimumSize(new Dimension(500,500));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
