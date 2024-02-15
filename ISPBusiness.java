package edu.iastate.cs228.hw1;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Sophie Waterman Hines
 *
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {
	
	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		for (int x = 0; x < tNew.getLength(); x++){
			for (int y = 0; y < tNew.getWidth(); y++){
				//Goes through the old town grid updates the new town grid with the
				//correct objects for the next cycle.
				tNew.grid[x][y] = tOld.grid[x][y].next(tNew);
			}
		}
		return tNew;
	}
	
	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) {

		//Spaces occupied by casuals
		int casuals = 0;

		for (int x = 0; x < town.getLength(); x++) {
			for (int y = 0; y < town.getWidth(); y++) {
				if (town.grid[x][y].who() == State.CASUAL) {
					casuals++;
				}
			}
		}
		return casuals;
	}
	

	/**
	 * Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *  
	 *  Depending on the user choice, create the Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *  
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should only print the integer part (Just print the 
	 *  integer value. Example if profit is 35.56%, your output should be just: 35).
	 *  
	 * Note that this method does not throws any exception, thus you need to handle all the exceptions
	 * in it.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String []args) throws FileNotFoundException {

		Scanner scan = new Scanner(System.in);
		String[] info;
		double total = 0;
		Town townie = new Town(0, 0);

		System.out.println("How to populate grid (type 1 or 2): 1: from a file. 2: randomly with seed");
		String input = scan.nextLine();

		if (input.equals("1")){
			System.out.println("Please enter your file path: ");
			input = scan.nextLine();
			townie = new Town(input);
		}
		else if(input.equals("2")){
			System.out.println("Please enter your rows, cols and seed separated by spaces:");
			info = scan.nextLine().split(" ");
			townie = new Town(Integer.parseInt(info[0]), Integer.parseInt(info[1]));
			townie.randomInit(Integer.parseInt(info[2]));
		}
		else{ // If the user does not enter a 1 or a 2.
			System.out.println("Invalid input! Please restart program.");
			System.exit(0);
		}

		scan.close();

		for (int x = 0; x < 12; x++){
			//Prints array
			System.out.print(townie.toString());
			//Adds profits
			total += getProfit(townie);
			//Prints this cycle's profits
			System.out.print("Profit: " + getProfit(townie));
			System.out.println();
			//Updates town to the next iteration
			townie = updatePlain(townie);
			System.out.println();
		}
		//Prints total profits
		System.out.println("Total profits percent: " + total/(townie.getWidth()*townie.getLength() * 12) * 100);
	}
}
