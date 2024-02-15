package edu.iastate.cs228.hw1;

/**
 * 
 * @author Sophie Waterman Hines
 *	Also provide appropriate comments for this class
 *
 */
public abstract class TownCell {

	protected Town plain;
	protected int row;
	protected int col;


	// constants to be used as indices.
	protected static final int RESELLER = 0;
	protected static final int EMPTY = 1;
	protected static final int CASUAL = 2;
	protected static final int OUTAGE = 3;
	protected static final int STREAMER = 4;

	public static final int NUM_CELL_TYPE = 5;

	//Use this static array to take census.
	public static final int[] nCensus = new int[NUM_CELL_TYPE];

	public TownCell(Town p, int r, int c) {
		plain = p;
		row = r;
		col = c;
	}

	/**
	 * Censuses all cell types in the 3 X 3 neighborhood
	 * Use who() method to get who is present in the
	 *
	 * @param nCensus counts of all customers
	 */
	public void census(int nCensus[]) {
		// zero the counts of all customers
		nCensus[RESELLER] = 0;
		nCensus[EMPTY] = 0;
		nCensus[CASUAL] = 0;
		nCensus[OUTAGE] = 0;
		nCensus[STREAMER] = 0;

		if(row == 0 && col == 0)  //Top left corner
		{
			determine(nCensus,plain.grid[0][1]);
			determine(nCensus,plain.grid[1][0]);
			determine(nCensus,plain.grid[1][1]);
		}
		else if(row == plain.getLength() - 1 && col == plain.getWidth() - 1)  //Bottom right corner
		{
			determine(nCensus,plain.grid[plain.getLength() - 1][plain.getWidth() - 2]);
			determine(nCensus,plain.grid[plain.getLength() - 2][plain.getWidth() - 1]);
			determine(nCensus,plain.grid[plain.getLength() - 2][plain.getWidth() - 2]);
		}
		else if(row == 0 && col == plain.getWidth() - 1)  //Top right corner
		{
			determine(nCensus,plain.grid[0][plain.getWidth() - 2]);
			determine(nCensus,plain.grid[1][plain.getWidth() - 1]);
			determine(nCensus,plain.grid[1][plain.getWidth() - 2]);
		}
		else if(row == plain.getLength() - 1 && col == 0)  //Bottom left corner
		{
			determine(nCensus,plain.grid[plain.getLength() - 1][1]);
			determine(nCensus,plain.grid[plain.getLength() - 2][0]);
			determine(nCensus,plain.grid[plain.getLength() - 2][1]);
		}
		else if(row == 0){ //Top
			determine(nCensus,plain.grid[row][col - 1]);
			determine(nCensus,plain.grid[row][col + 1]);
			determine(nCensus,plain.grid[row + 1][col - 1]);
			determine(nCensus,plain.grid[row + 1][col]);
			determine(nCensus,plain.grid[row + 1][col + 1]);
		}
		else if(col == 0){ //Left
			determine(nCensus,plain.grid[row - 1][col]);
			determine(nCensus,plain.grid[row + 1][col]);
			determine(nCensus,plain.grid[row - 1][col + 1]);
			determine(nCensus,plain.grid[row][col + 1]);
			determine(nCensus,plain.grid[row + 1][col + 1]);
		}
		else if(row == plain.getLength() - 1){ //Bottom
			determine(nCensus,plain.grid[row][col - 1]);
			determine(nCensus,plain.grid[row][col + 1]);
			determine(nCensus,plain.grid[row - 1][col - 1]);
			determine(nCensus,plain.grid[row - 1][col]);
			determine(nCensus,plain.grid[row - 1][col + 1]);
		}
		else if(col == plain.getWidth() - 1){ //Right
			determine(nCensus,plain.grid[row - 1][col]);
			determine(nCensus,plain.grid[row + 1][col]);
			determine(nCensus,plain.grid[row - 1][col-1]);
			determine(nCensus,plain.grid[row][col-1]);
			determine(nCensus,plain.grid[row + 1][col-1]);
		}
		else{ //Everything else
			determine(nCensus,plain.grid[row-1][col]);
			determine(nCensus,plain.grid[row+1][col]);
			determine(nCensus,plain.grid[row][col-1]);
			determine(nCensus,plain.grid[row][col+1]);
			determine(nCensus,plain.grid[row+1][col+1]);
			determine(nCensus,plain.grid[row-1][col-1]);
			determine(nCensus,plain.grid[row+1][col-1]);
			determine(nCensus,plain.grid[row-1][col+1]);
			}
		}

	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public abstract TownCell next(Town tNew);

	/**
	 * A helper function that adds 1 to the correct position in census depending
	 * on what who() returns for any given cell.
	 *
	 * @param counter: The array being added to
	 * @param cell: The cell being evaluated
	 */
	private void determine(int counter[], TownCell cell)
	{
		switch(cell.who())
		{
			case RESELLER:
				counter[RESELLER]++;
				break;
			case EMPTY:
				counter[EMPTY]++;
				 break;
			case CASUAL:
				counter[CASUAL]++;
				break;
			case OUTAGE:
				counter[OUTAGE]++;
				break;
			case STREAMER:
				counter[STREAMER]++;
				break;
		}
	}
}
