package edu.iastate.cs228.hw1.test;

import edu.iastate.cs228.hw1.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TownCellTest {

    @Test
    public void testCensus(){
        Town town = new Town(3, 3);
        int[] arr;

        town.grid[0][0] = new Casual(town, 0, 0);
        town.grid[0][1] = new Outage(town, 0, 1);
        town.grid[0][2] = new Reseller(town, 0, 2);
        town.grid[1][0] = new Streamer(town, 1, 0);
        town.grid[1][1] = new Empty(town, 1, 1);
        town.grid[1][2] = new Reseller(town, 1, 2);
        town.grid[2][0] = new Streamer(town, 2, 0);
        town.grid[2][1] = new Outage(town, 2, 1);
        town.grid[2][2] = new Casual(town, 2, 2);

        town.grid[0][0].census(TownCell.nCensus);
        arr = new int[]{0, 1, 0, 1, 1};
        assertArrayEquals(town.grid[0][0].nCensus, arr);
        town.grid[0][1].census(TownCell.nCensus);
        arr = new int[]{2, 1, 1, 0, 1};
        assertArrayEquals(town.grid[0][1].nCensus, arr);
        town.grid[0][2].census(TownCell.nCensus);
        arr = new int[]{1, 1, 0, 1, 0};
        assertArrayEquals(town.grid[0][2].nCensus, arr);
        town.grid[1][0].census(TownCell.nCensus);
        arr = new int[]{0, 1, 1, 2, 1};
        assertArrayEquals(town.grid[1][0].nCensus, arr);
        town.grid[1][1].census(TownCell.nCensus);
        arr = new int[]{2, 0, 2, 2, 2};
        assertArrayEquals(town.grid[1][1].nCensus, arr);
        town.grid[1][2].census(TownCell.nCensus);
        arr = new int[]{1, 1, 1, 2, 0};
        assertArrayEquals(town.grid[1][2].nCensus, arr);
        town.grid[2][0].census(TownCell.nCensus);
        arr = new int[]{0, 1, 0, 1, 1};
        assertArrayEquals(town.grid[2][0].nCensus, arr);
        town.grid[2][1].census(TownCell.nCensus);
        arr = new int[]{1, 1, 1, 0, 2};
        assertArrayEquals(town.grid[2][1].nCensus, arr);
        town.grid[2][2].census(TownCell.nCensus);
        arr = new int[]{1, 1, 0, 1, 0};
        assertArrayEquals(town.grid[2][2].nCensus, arr);
    }

}
