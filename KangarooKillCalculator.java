/**
 * Bruce Gavins
 * MSI-5030
 * Programming Assignment 2.1
 */
import java.util.Scanner; 

/**
 * A program that takes the measurements of a land area, the amount of roadway in that area,
 * the number of kangaroos in the area, and then predicts how many kangaroos will be killed 
 * by motorists per year
 */

/** 
 * Defining the main class for the program which will take input from the user and 
 * implement the algorithm for predicting kill count 
 */
public class KangarooKillCalculator {
	// Road width constant in meters (converted to km for calculation)
	private static final double ROAD_WIDTH_KM = 0.01;
	//Road kill probability constant
	private static final double KILL_PROBABILITY = 1.47;
	
	public static void main(String[] args) {
		// Scanner object for user input
		Scanner scanner = new Scanner(System.in);
		
		//Obtain user input
		System.out.print("Enter the side length of the square of land in km: ");
		double sideLength = scanner.nextDouble();
		
		System.out.print("Enter the road length running through the square in km: ");
		double roadLength = scanner.nextDouble();
		
		System.out.print("Enter the number of kangaroos living in the square: ");
		int kangarooCount = scanner.nextInt();
		
		//Calculate expected kangaroo kills from user input values
		double expectedKills = calculateExpectedKills(sideLength, roadLength, kangarooCount);
		
		//Print result to screen
		System.out.printf("Expected number of kills: %.1f%n", expectedKills);
		
		//close scanner utility
		scanner.close();
	}
	
	/**
	 * Method which contains the algorithm to predict the kill amount
	 * 
	 * sideLength The length of the side of the square of land in kilometers 
	 * roadLength The length of roads running through the square in kilometers
	 * kangarooCount The number of kangaroos living within the square 
	 * The expected number of kangaroo road kills in a year, within the land area 
	 */
	private static double calculateExpectedKills(double sideLength, double roadLength, int kangarooCount) {
		//Calculate the area of the square in square kilometers
		double landArea = sideLength * sideLength;
		
		//Calculate the number of kangaroos per square mile
		double kangarooDensity = (double)kangarooCount / landArea;
		
		//Calculate road surface area in square kilometers 
		double roadSurfaceArea = roadLength * ROAD_WIDTH_KM;
		
		//Calculate expected kills within the specified land area 
		return kangarooDensity * roadSurfaceArea * KILL_PROBABILITY;
	}
}
