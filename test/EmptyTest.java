package edu.iastate.cs228.hw1.test;

import edu.iastate.cs228.hw1.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmptyTest{

    @Test
    public void testEmpty(){
        Town town = new Town(5, 5);
        Empty empty = new Empty(town, 0, 1);
        assertNotNull(empty);
    }

    @Test
    public void testWho(){
        Town town = new Town(5, 5);
        Empty empty = new Empty(town, 0, 1);
        assertEquals(empty.who(), State.EMPTY);
    }

    @Test
    public void testNext(){
        Town oldtown = new Town(4, 4);
        Town newtown = new Town(4, 4);
        oldtown.randomInit(10);

        assertEquals(oldtown.grid[1][0].next(newtown).who(), State.CASUAL);
    }

}