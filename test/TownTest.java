package edu.iastate.cs228.hw1.test;

import edu.iastate.cs228.hw1.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class TownTest{

    @Test
    public void RandomInitTest(){
        Town town = new Town(4, 4);
        town.randomInit(10);

        assertEquals(town.grid[0][0].who(), State.OUTAGE);
        assertEquals(town.grid[1][1].who(), State.EMPTY);
        assertEquals(town.grid[2][2].who(), State.OUTAGE);
        assertEquals(town.grid[3][3].who(), State.RESELLER);
    }

    @Test
    public void toStringTest() {
        Town town = new Town(3, 3);

        town.grid[0][0] = new Casual(town, 0, 0);
        town.grid[0][1] = new Outage(town, 0, 1);
        town.grid[0][2] = new Reseller(town, 0, 2);
        town.grid[1][0] = new Streamer(town, 1, 0);
        town.grid[1][1] = new Empty(town, 1, 1);
        town.grid[1][2] = new Reseller(town, 1, 2);
        town.grid[2][0] = new Streamer(town, 2, 0);
        town.grid[2][1] = new Outage(town, 2, 1);
        town.grid[2][2] = new Casual(town, 2, 2);

        String expected = "C\tO\tR\t\nS\tE\tR\t\nS\tO\tC\t\n";
        assertEquals(town.toString(), expected);
    }

    @Test
    public void fileTest() throws FileNotFoundException {
        Town town = new Town("src\\ISP4x4.txt");

        String predicted = "O\tR\tO\tR\t\nE\tE\tC\tO\t\nE\tS\tO\tS\t\nE\tO\tR\tR\t\n";
        assertEquals(town.toString(), predicted);
    }
}
