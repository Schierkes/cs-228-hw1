package edu.iastate.cs228.hw1.test;

import edu.iastate.cs228.hw1.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OutageTest{

    @Test
    public void testOutage(){
        Town town = new Town(5, 5);
        Outage outage = new Outage(town, 0, 1);
        assertNotNull(outage);
    }

    @Test
    public void testWho(){
        Town town = new Town(5, 5);
        Outage outage = new Outage(town, 0, 1);
        assertEquals(outage.who(), State.OUTAGE);
    }

    @Test
    public void testNext(){
        Town oldtown = new Town(4, 4);
        Town newtown = new Town(4, 4);
        oldtown.randomInit(10);

        assertEquals(oldtown.grid[0][0].next(newtown).who(), State.EMPTY);
    }

}