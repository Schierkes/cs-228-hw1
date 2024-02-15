package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


/**
 *  @author Sophie Waterman Hines
 *
 */
public class Town {
	
	private int length, width;  //Row and col (first and second indices)
	public TownCell[][] grid;
	
	/**
	 * Constructor to be used when user wants to generate grid randomly, with the given seed.
	 * This constructor does not populate each cell of the grid (but should assign a 2D array to it).
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) {

		this.length = length;
		this.width = width;
		grid = new TownCell[length][width];

	}
	
	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of catching it.
	 * Ensure that you close any resources (like file or scanner) which is opened in this function.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {

		File file = new File(inputFileName);
		Scanner scan = new Scanner(file);
		int count = 0;

		//Holds the length and width
		String[] hold = scan.nextLine().split(" ");

		width = Integer.parseInt(hold[1]);
		length = Integer.parseInt(hold[0]);

		grid = new TownCell[length][width];

		for (int x = 0; x < length; x++) {
			//Splits the given line into an array for easier evaluation.
			hold = scan.nextLine().split(" ");
			for (int y = 0; y < width; y++) {
				switch (hold[y]) {
					case "R":
						grid[x][y] = new Reseller(this, x, y);
						break;
					case "E":
						grid[x][y] = new Empty(this, x, y);
						break;
					case "C":
						grid[x][y] = new Casual(this, x, y);
						break;
					case "O":
						grid[x][y] = new Outage(this, x, y);
						break;
					case "S":
						grid[x][y] = new Streamer(this, x, y);
						break;
				}
			}
		}
		scan.close();
	}
	
	/**
	 * Returns width of the grid.
	 * @return
	 */
	public int getWidth() {

		return width;

	}
	
	/**
	 * Returns length of the grid.
	 * @return
	 */
	public int getLength() {

		return length;

	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following class object:
	 * Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);

		for (int x = 0; x < length; x++) {
			for (int y = 0; y < width; y++) {
				switch (rand.nextInt(5)) {
					case 0:
						grid[x][y] = new Reseller(this, x, y);
						break;
					case 1:
						grid[x][y] = new Empty(this, x, y);
						break;
					case 2:
						grid[x][y] = new Casual(this, x, y);
						break;
					case 3:
						grid[x][y] = new Outage(this, x, y);
						break;
					case 4:
						grid[x][y] = new Streamer(this, x, y);
						break;
				}
			}
		}
	}
	
	/**
	 * Output the town grid. For each square, output the first letter of the cell type.
	 * Each letter should be separated either by a single space or a tab.
	 * And each row should be in a new line. There should not be any extra line between 
	 * the rows.
	 */
	@Override
	public String toString() {
		String s = "";
		for (int x = 0; x < length; x++){
			for (int y = 0; y < width; y++){
				switch (grid[x][y].who()) {
					case STREAMER:
						s += "S\t";
						break;
					case OUTAGE:
						s += "O\t";
						break;
					case CASUAL:
						s += "C\t";
						break;
					case RESELLER:
						s += "R\t";
						break;
					case EMPTY:
						s += "E\t";
						break;
				}
			}
			s += "\n";
		}
		return s;
	}
}
