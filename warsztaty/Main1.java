package warsztaty;

import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
    	guessNumber();
    }
    static void guessNumber() {
    	Scanner number = new Scanner(System.in);
    	Random r = new Random();
    	int randInt = r.nextInt(100)+1;
    	System.out.println("Zgadnij liczbe! (z zakresu 1-100");
    }
    
}