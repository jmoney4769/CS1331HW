import java.util.Scanner;

import javax.swing.JOptionPane;

/** Class used to test the WelcomeSign and Location classes
 * @author jmoney4769
 * @version 09/26/12
 */
public class WelcomeSignGenerator {

	/** Main method running the program
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(JOptionPane.showInputDialog("Enter a city and state separated by a space:  "));		
		WelcomeSign sign = new WelcomeSign(new Location(input.next(), input.next()));
		sign.showWelcomeSign();
	}
}
