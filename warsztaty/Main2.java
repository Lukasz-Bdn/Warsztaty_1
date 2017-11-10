package warsztaty;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		lotto();
	}

	static void lotto() {
		int[] drawNumbers=getDrawNumbers();
		int[] myNumbers = getMyNumbers();
//		int[] myNumbers = {1, 22, 34, 39, 43, 48};
		System.out.println(Arrays.toString(drawNumbers));
		System.out.println(Arrays.toString(myNumbers));
		int counter =0;
		for (int myNumber : myNumbers) {
			if (checkInArray(drawNumbers, myNumber)) {
				counter++;
			}
		}
		System.out.println("Ilosc trafionych liczb to " + counter);
	}

	public static int[] getMyNumbers() {
		Scanner scan = new Scanner(System.in);
		int numIndex = 0;
		int number = 0;
		int[] myNumbers = new int[6];
		System.out.println("Podaj szesc liczb");
		while (numIndex < 6) {
			System.out.println("Podaj liczbe (potrzeba jeszcze " + (6-numIndex) 
					+ " liczb): " );
			try {
				number = scan.nextInt();
				if (number >= 1 && number <= 49) {
					if (!checkInArray(myNumbers, number)) {
						myNumbers[numIndex] = number;
						numIndex++;
					} else {
						System.out.println("Liczby nie moga sie powtarzac");
					}
				} else {
					System.out.println("Niewlasciwa liczba (musi byc z zakresu 1-49)");
				}
			} 
			
			catch (InputMismatchException e) {
				System.out.println("To nie jest liczba");
				scan.nextLine();
			}
		}
		Arrays.sort(myNumbers);
		scan.close();
		return myNumbers;
	}

	public static int[] getDrawNumbers() {
		Integer[] arr = new Integer[49];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		Collections.shuffle(Arrays.asList(arr));
		int[] drawNumbers = new int[6];
		for (int i=0; i<6; i++) {
			drawNumbers[i] = arr[i];
		}
		Arrays.sort(drawNumbers);
//		System.out.println(Arrays.toString(drawNumbers));
		return drawNumbers;
	}
	
	public static boolean checkInArray(int[] array, int number) {
		for (int element : array) {
			if (element==number) {
				return true;
			}
		}
		return false;
	}
}