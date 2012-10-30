import java.awt.Dimension;

import javax.swing.JFrame;

/** Class used to run and test Pet and PetPanel
 * @author Jared Moore
 * @version 10/3/12
 */
public class PetMain {

	/** Main method to run the classes
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(500, 500));
		PetPanel panel = new PetPanel(new Pet());
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
