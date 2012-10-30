/** Class to perform operations on binary numbers, presented as Strings
 * In order to help learn course concepts, I worked on this homework with Johnnie Tirado 
 * @author Jared Moore
 * @version 10/17/12
 */
public class BinaryOperations {

	/** Convert a binary String into its integer equivalent
	 * @param number - the binary String
	 * @return total - the integer equivalent of number
	 */
	private static int convertToInt(String number) {
		char[] first = number.toCharArray();
		char[] array = new char[first.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = first[array.length - i - 1];
		}
		int total = 0;
		for (int i = 0; i < array.length; i++) {
			if (Integer.valueOf(Character.toString(array[i])) == 1)
				total += Math.pow(2, i);
		}
		return total;
	}
	
	/** Add two binary Strings
	 * @param number - the first binary String to be added
	 * @param secondNumber - the second binary String
	 * @return the sum of the two numbers
	 */
	public static String plus(String number, String secondNumber) {		
		
		int first = BinaryOperations.convertToInt(number);
		int second = BinaryOperations.convertToInt(secondNumber);
		return Integer.toBinaryString(first + second);
	}
	
	/** Subtract two binary Strings, make sure the result is not negative
	 * @param number - the first binary String
	 * @param secondNumber - the second binary String to be subtracted from the first
	 * @return the difference between the two numbers
	 * @throws ArithmeticException - if the answer would be negative, so that it can be handled in the Panel
	 */
	public static String minus(String number, String secondNumber) throws ArithmeticException {
		int first = BinaryOperations.convertToInt(number);
		int second = BinaryOperations.convertToInt(secondNumber);
		if ((first - second) < 0)
			throw new ArithmeticException();
		return Integer.toBinaryString(first - second);
	}
	
	/** Multiply two binary Strings
	 * @param number - the first binary String to be multiplied
	 * @param secondNumber - the second binary String
	 * @return the product of the two numbers
	 */
	public static String multiply(String number, String secondNumber) {
		int first = BinaryOperations.convertToInt(number);
		int second = BinaryOperations.convertToInt(secondNumber);
		return Integer.toBinaryString(first * second);
	}
	
	/** Divide two binary Strings
	 * @param number - the first binary String 
	 * @param secondNumber - the second binary String
	 * @return the quotient of the two Strings
	 */
	public static String divide(String number, String secondNumber) {
		int first = BinaryOperations.convertToInt(number);
		int second = BinaryOperations.convertToInt(secondNumber);
		return Integer.toBinaryString(first / second);
	}
	
	/** Perform the NOT operation on a binary String
	 * @param number - the String to perform the action
	 * @return - the parameter with all of the 0's = 1 and 1's = 0
	 */
	public static String not(String number) {
		char[] array = number.toCharArray();
		number = "";
		for (char i : array) {
			if (i == '1')
				number += "0";
			else
				number += "1";
		}
		return number;
	}
	
	/** Perform the AND operation on two binary Strings
	 * @param number - the first binary String
	 * @param secondNumber - the second binary String
	 * @return A String with 1's in the positions where both have 1's and 0's otherwise
	 */
	public static String and(String number, String secondNumber) {
		
		char[][] bigArray = makeArray(number, secondNumber);
		
		for (int i = 0; i < bigArray[0].length; i++) {
			
			if ((bigArray[0][i] == '1') && (bigArray[1][i] == '1'))
				bigArray[2][i] = '1';
			else 
				bigArray[2][i] = '0';
		}
		
		String s = "";
		for (char i : bigArray[2])
			s += Character.toString(i);
		return s;
	}
	
	/** Perform the OR operation on two binary Strings
	 * @param number - the first binary String
	 * @param secondNumber - the second binary String
	 * @return A String with 1's where both or 1 of the Strings had a 1 and 0's elsewhere
	 */
	public static String or(String number, String secondNumber) {
		
		char[][] bigArray = makeArray(number, secondNumber);
		
		for (int i = 0; i < bigArray[0].length; i++) {
					
				if ((bigArray[0][i] == '1') || (bigArray[1][i] == '1'))
					bigArray[2][i] = '1';
				else 
					bigArray[2][i] = '0';
			}
				
			String s = "";
			for (char i : bigArray[2])
				s += Character.toString(i);
			return s;
	}
	
	/** Perform the XOR operation on two binary Strings
	 * @param number - the first binary String
	 * @param secondNumber - the second binary String
	 * @return A String with 1's where only one of the two had 1's, 0's elsewhere
	 */
	public static String xor(String number, String secondNumber) {
		
		char[][] bigArray = makeArray(number, secondNumber);
		
		for (int i = 0; i < bigArray[0].length; i++) {
					
				if ((bigArray[0][i] == '1') ^ (bigArray[1][i] == '1'))
					bigArray[2][i] = '1';
				else 
					bigArray[2][i] = '0';
			}
				
			String s = "";
			for (char i : bigArray[2])
				s += Character.toString(i);
			return s;
	}

	/** Make a two-dimensional array for use in binary operations and also make sure the two Strings are the same length
	 * @param number - the first Binary string to use
	 * @param secondNumber - the second binary String to use
	 * @return a two-dimensional char array with each row of equal length
	 */
	private static char[][] makeArray(String number, String secondNumber) {
		if (number.length() != secondNumber.length()) {
			while (number.length() > secondNumber.length()) 
				secondNumber = "0" + secondNumber;
			while (number.length() < secondNumber.length())
				number = "0" + number;
		}
		char[] array1 = number.toCharArray();
		char[] array2 = secondNumber.toCharArray();
		
		char[][] bigArray = new char[3][array1.length];
		bigArray[0] = array1;
		bigArray[1] = array2;
		return bigArray;
	}
	
}
