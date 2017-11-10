package warsztaty;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
    	guessNumber();
    }
    static void guessNumber() {
    	Random r = new Random();
    	int number = r.nextInt(101);
    	System.out.println(number);
    	int answer = -1;
    	
    	Scanner scan = new Scanner(System.in);
    	while (number !=answer) {
    		System.out.println("Zgadnij liczbe");
    		try {
				answer = scan.nextInt();
				if (answer>number) {
					System.out.println("Za duzo");
				} else if (answer < number){
					System.out.println("Za malo");
				}
			} catch (InputMismatchException e) {
				System.out.println("To nie jest liczba");
				scan.nextLine();
			}
    	}
    	System.out.println("Zgadles");
    	scan.close();
    }
}