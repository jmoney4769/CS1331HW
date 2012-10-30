import java.util.Scanner;

/** Class used to translate to and from "LeetSpeak"
 * 
 * @author jmoney4769
 *
 */
public class LeetTranslator {

	/** Precondition:  The program has not run yet
	 *  Postcondition:  The program outputs the desired translation
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 1 to translate to LeetSpeak, 2 to translate back from LeetSpeak  ");
		int choice = input.nextInt();
		
		String output = "";
		input = new Scanner(System.in);
		if (choice == 1) {
			System.out.print("\nWhat would you like to translate to LeetSpeak?  ");
			String s = input.nextLine();
			output = LeetTranslator.translateTo(s);
		}
		else if (choice == 2) {
			System.out.print("\nWhat would you like to translate from LeetSpeak?  ");
			String s = input.nextLine();
			output = LeetTranslator.translateFrom(s);
		}
		
		System.out.printf("\n\n%s", output);
	}
		
	/** Precondition:  The user wants to translate from a String of text in LeetSpeak
	 *  Postcondition:  The method returns a String that has been translated
	 * @param s - the original String 
	 * @return the correctly formatted String
	 */
	public static String translateFrom(String s) {
			
		return s.replace('@', 'a').replace('3', 'e').replace('1', 'i').replace('$', 's').replace('0', 'o');
	}

	/** Precondition:  The user wants to translate a String of text to LeetSpeak
	 *  Postcondition:  The method returns a String that has been translated
	 * @param s - the original String 
	 * @return the correctly formatted String
	 */
	public static String translateTo(String s) {
		return s.replace('a', '@').replace('e', '3').replace('i', '1').replace('s', '$').replace('o', '0');
	}
}
