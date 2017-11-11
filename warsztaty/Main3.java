package warsztaty;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		int min = 0;
		int max = 1000;
		guessNum(min, max);
	}
	
	public static void guessNum(int min, int max) {
		System.out.println("Pomysl liczbe od "+min+" do "+max+", a ja zgadne ja w max 10 probach");
		int guess = ((max-min)/2)+min;
		Scanner scan = new Scanner(System.in);
		String answer = "nothing";
		int counter = 1;
		while (true) {
			System.out.println("Czy Twoja liczba to " + guess+ "?");
			answer = scan.nextLine();
			if (answer.equals("zgadles")) {
				System.out.println("Wygralem po "+counter+" probach!");
				return;
			} else if (answer.equals("za duzo")){
				max = guess;
				counter++;
			} else if (answer.equals("za malo")) {
				min = guess;
				counter++;
			} else {
				System.out.println("Podaj poprawna odpowiedz (zgadles, za malo, za duzo).");
			}
			guess = ((max-min)/2)+min;
		}
	}
}