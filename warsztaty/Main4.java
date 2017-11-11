package warsztaty;

import java.util.Random;

public class Main4 {

	public static void main(String[] args) {
		String cubeToUse = "D2+1";
		System.out.println(drawCube(cubeToUse));
	}
	
	/*
	 * Returns the final result of drawing, after adding additional 
	 */
	static int drawCube(String cubeToUse) {
		System.out.println(cubeToUse);
		int numDraws = getNumOfDraws(cubeToUse);
		int cubeType = getCubeType(cubeToUse);
		int toBeAdded = getToBeAdded(cubeToUse);
		int draw = draw(cubeType, numDraws)+toBeAdded;
		return draw;
	}
	
	/*
	 *  Returns the first number in cube description, that describes the
	 *  number of draws. If it does not exist it returns 1.
	 */
	static int getNumOfDraws (String cubeToUse) {
		String numDrawsString = "";
		int numDraws = 1;
		for (int i=1; i<cubeToUse.length(); i++) {
			try {
				numDrawsString = cubeToUse.substring(0, i);
				numDraws = Integer.parseInt(numDrawsString);
			} catch (NumberFormatException e) {
				return numDraws;
			}
		}
		return numDraws;
	}
	
	/*
	 * Returns the number that represents the type of cube: for 10 it means
	 * cube has 10 sides (so it can give numbers from 1 to 10)
	 */
	static int getCubeType(String cubeToUse) {
		int indexOfD = cubeToUse.indexOf('D') +1;
		int indexOfPlus = cubeToUse.indexOf('+');
		if (indexOfPlus==-1) {
			indexOfPlus = cubeToUse.length();
		}
		String cubeTypeString = cubeToUse.substring(indexOfD, indexOfPlus);
		int cubeType = Integer.parseInt(cubeTypeString);
		return cubeType;
	}
	
	/*
	 * Returns the number that needs to be added to the result after draw.
	 * For cube 2D10+20 it will be 20.
	 */
	static int getToBeAdded(String cubeToUse) {
		int indexOfPlus = cubeToUse.indexOf('+');
		if (indexOfPlus==-1) {
			return 0;
		}
		String toBeAddedString = cubeToUse.substring(indexOfPlus);
		int toBeAdded = Integer.parseInt(toBeAddedString);
		return toBeAdded;
	}
	
	/*
	 * Starting with how many draws we need and cube type (range of numbers that
	 * can be drown) it returns the final result of all draws.
	 */
	static int draw(int cubeType, int numOfDraws) {
		Random r = new Random();
		int draw = 0;
		for (int i=0; i<numOfDraws; i++) {
			draw += r.nextInt(cubeType) + 1;
		}
		return draw;
	}
}