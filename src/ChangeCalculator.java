import java.util.Scanner;

/**
 * A simple calculator for giving change in the highest denominations possible
 * @author Jared Moore
 *
 */
public class ChangeCalculator {

	/**
	 * Run the class, calculating the change for a given amount
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Amount:  $");
		double amount = input.nextDouble(); // get the amount
		System.out.println(ChangeCalculator.calculateChange(amount));
	}
	
	/** Precondition:  The user has inputed a positive double variable 
	 *  Postcondition:  A string is returned with the amount of change given in each denomination
	 * @param amount
	 * @return String result
	 */
	public static String calculateChange(double amount) {
		int count20 = 0, count10 = 0, count5 = 0, count1 = 0, countQuart = 0, countDime = 0, countNik = 0, countPen = 0;
		// to count each individual denomination
		while (amount > 0) {
			if (amount >= 20.00) {
				count20++;
				amount -= 20.0;
			}
			else if (amount >= 10.0) {
				count10++;
				amount -= 10.0;
			}
			else if (amount >= 5.0) {
				count5++;
				amount -= 5.0;
			}
			else if (amount >= 1.0) {
				count1++;
				amount -= 1.0;
			}
			else if (amount >= 0.25) {
				countQuart++;
				amount -= 0.25;
			}
			else if (amount >= 0.1) {
				countDime++;
				amount -= 0.1;
			}
			else if (amount >= 0.05) {
				countNik++;
				amount -= 0.05;
			}
			else if (amount >  0) {
				countPen++;
				amount -= 0.01;
			}
		}
		String result = String.format("%d twenty dollar bills\n%d ten dollar bills\n%d five dollar bills\n%d one dollar bills\n%d" +
				" quarters\n%d dimes\n%d nickels\n%d pennies", count20, count10, count5, count1, countQuart, countDime, countNik, countPen); 
		// create the output string
		return result;
	}
}
