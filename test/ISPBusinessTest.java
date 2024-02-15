package edu.iastate.cs228.hw1.test;

import edu.iastate.cs228.hw1.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ISPBusinessTest {

    @Test
    public void testProfit(){

        Town town = new Town(4, 4);
        town.randomInit(10);

        assertEquals(ISPBusiness.getProfit(town), 1);

    }

    @Test
    public void testUpdatePlain(){

        Town town = new Town(2, 2);
        town.grid[0][0] = new Casual(town, 0, 0);
        town.grid[0][1] = new Empty(town, 0, 0);
        town.grid[1][0] = new Empty(town, 0, 0);
        town.grid[1][1] = new Outage(town, 0, 0);

        town = ISPBusiness.updatePlain(town);

        assertEquals(town.toString(), "C\tC\t\nC\tE\t\n");

    }

}
