import java.util.Scanner;


public class GTBuzz {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("What is your name? ");
		String name = input.nextLine();
		System.out.printf("Hello %s, you are an amazing person :)", name);
	}
}
