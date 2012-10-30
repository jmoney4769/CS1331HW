import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/** Class used to display a Binary calculator
 * @author Jared Moore
 * @version 10/17/12
 */
public class CalculatorScreenPanel extends JPanel {

	private JLabel entry;
	private JButton one, zero, plus, minus, divide, multiply, equals, clear, and, not, or, xor;
	private JPanel buttons;
	private String firstEntry =  "", operation;
	private boolean isFirst = true, hasInput = false, hasAnswer = false;
	
	/** Constructor for CalculatorScreenPanel
	 *  Sets up a JPanel with all of the necessary components of a calculator
	 */
	public CalculatorScreenPanel() {
		
		entry = new JLabel();
		entry.setFont(new Font(null, 0, 32));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(entry);
		add(Box.createRigidArea(new Dimension(100, 100)));	
		
		buttons = new JPanel();
		
		or = new JButton("OR");
		one = new JButton("1");
		zero = new JButton("0");
		plus = new JButton("+");
		and = new JButton("AND");
		not = new JButton("NOT");
		xor = new JButton("XOR");
		minus = new JButton("-");
		clear = new JButton("CA");
		equals = new JButton("=");
		divide = new JButton("/");
		multiply = new JButton("*");
		
		ButtonListener bl = new ButtonListener();
		
		or.addActionListener(bl);
		one.addActionListener(bl);
		and.addActionListener(bl);
		not.addActionListener(bl);
		xor.addActionListener(bl);
		zero.addActionListener(bl);
		plus.addActionListener(bl);
		minus.addActionListener(bl);
		clear.addActionListener(bl);
		divide.addActionListener(bl);
		equals.addActionListener(bl);
		multiply.addActionListener(bl);		
		
		buttons.setLayout(new GridLayout(3, 4));
		
		buttons.add(one);
		buttons.add(zero);
		buttons.add(plus);
		buttons.add(minus);
		buttons.add(multiply);
		buttons.add(divide);
		buttons.add(clear);
		buttons.add(equals);
		buttons.add(not);
		buttons.add(and);
		buttons.add(or);
		buttons.add(xor);
		
		add(buttons);
		
	}
	
	/** Private class used to handle events on buttons
	 * @author Jared Moore
	 * @version 10/17/12
	 */
	private class ButtonListener implements ActionListener {
		
		@Override
		/** Handle the event generated when a button is clicked
		 * @param e - the event that was generated
		 */
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == one)
				if (hasInput) // if there's already input, add one to the value, otherwise, make a new String and set hasInput to true
					entry.setText(entry.getText() + 1);
				else {
					entry.setText("1");
					hasInput = true;
				}
			else if (e.getSource() == zero)
				if (hasInput)
					entry.setText(entry.getText() + 0);
				else {
					entry.setText("0");
					hasInput = true;
				}
			else if (e.getSource() == plus) {
				if (hasInput || hasAnswer) { // if there's already an text visible, set the operation and save that input
					saveInput();
					operation = "plus";					
				}
				else if (!firstEntry.equals("")) // else change the operation.  Nothing will be done if there has been nothing entered 
					operation = "plus";
			}
			else if (e.getSource() == minus) {
				if (hasInput || hasAnswer) {
					saveInput();
					operation = "minus";
				}
				else if (!firstEntry.equals(""))
					operation = "minus";
			}
			else if (e.getSource() == multiply) {
				if (hasInput || hasAnswer) {
					saveInput();
					operation = "multiply";
				}
				else if (!firstEntry.equals(""))
					operation = "multiply";
			}
			else if (e.getSource() == divide) {
				if (hasInput || hasAnswer) {
					saveInput();
					operation = "divide";
				}
				else if (!firstEntry.equals(""))
					operation = "divide";
			}
			else if (e.getSource() == equals) {
				performOperation();
				isFirst = true;
				hasInput = false;
				firstEntry = entry.getText(); // save the input, in case the user wants to perform an operation on the result
			}
			else if (e.getSource() == clear) { // get rid of everything
				firstEntry = "";
				entry.setText("");
				hasInput = false;
				operation = "";
			}
			else if (e.getSource() == not) {
				if ((hasInput || hasAnswer) || (!firstEntry.equals(""))) { // make sure there is something to perform the operation on
					operation = "not";
					performOperation();
				}
			}
			else if (e.getSource() == and) {
				if (hasInput || hasAnswer) {
					saveInput();
					operation = "and";
				}
				else if (!firstEntry.equals(""))
					operation = "and";
			}
			else if (e.getSource() == or) {
				if (hasInput || hasAnswer) {
					saveInput();
					operation = "or";
				}
				else if (!firstEntry.equals(""))
					operation = "or";
			}
			else if (e.getSource() == xor) {
				if (hasInput || hasAnswer) {
					saveInput();
					operation = "xor";
				}
				else if (!firstEntry.equals(""))
					operation = "xor";
			}
		}
	}

	/** Save the input in the calculator and perform the operation if it is the second piece entered 
	 */
	private void saveInput() {
		if (!isFirst) {
			performOperation();
		}
		firstEntry = entry.getText();
		isFirst = false;
		hasInput = false;
	}

	/** Perform the selected operation on the numbers entered
	 */
	private void performOperation() {
		
		if (operation == null || operation.equals("")) // do nothing if there was no operation selected
			return;
		
		switch (operation) {
		case "plus":
			entry.setText(BinaryOperations.plus(firstEntry, entry.getText()));
			break;
			
		case "minus":
			try { // handle any errors that may come up to make sure that the calculator does not crash
			entry.setText(BinaryOperations.minus(firstEntry, entry.getText()));
			}
			catch (Exception exception) {
				JOptionPane.showMessageDialog(null, "You came up with a negative answer\nSadly, this calculator cannot handle such numbers", "Error", JOptionPane.ERROR_MESSAGE);
				entry.setText("");
				firstEntry = "";
			}
			break;
			
		case "multiply":
			entry.setText(BinaryOperations.multiply(firstEntry, entry.getText()));
			break;
			
		case "divide":
			try {
				entry.setText(BinaryOperations.divide(firstEntry, entry.getText()));
			}
			catch (Exception exception) {
				JOptionPane.showMessageDialog(null, "Unfortunately, one cannot divide by zero\nPlease try another input", "Error", JOptionPane.ERROR_MESSAGE);
				entry.setText("");
				firstEntry = "";
			}
			break;
			
		case "not":
			entry.setText(BinaryOperations.not(entry.getText()));
			break;
			
		case "and":
			entry.setText(BinaryOperations.and(firstEntry, entry.getText()));
			break;
			
		case "or":
			entry.setText(BinaryOperations.or(firstEntry, entry.getText()));
			break;
			
		case "xor":
			entry.setText(BinaryOperations.xor(firstEntry, entry.getText()));
			
		}
		hasAnswer = true;
	}
}
