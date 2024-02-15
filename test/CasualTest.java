package edu.iastate.cs228.hw1.test;

import edu.iastate.cs228.hw1.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CasualTest {

    @Test
    public void testCasual(){
        Town town = new Town(5, 5);
        Casual casual = new Casual(town, 0, 1);
        assertNotNull(casual);
    }

    @Test
    public void testWho(){
        Town town = new Town(5, 5);
        Casual casual = new Casual(town, 0, 1);
        assertEquals(casual.who(), State.CASUAL);
    }

    @Test
    public void testNext(){
        Town oldtown = new Town(4, 4);
        Town newtown = new Town(4, 4);
        oldtown.randomInit(10);

        assertEquals(oldtown.grid[1][2].next(newtown).who(), State.OUTAGE);
    }

}
