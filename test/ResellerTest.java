package edu.iastate.cs228.hw1.test;

import edu.iastate.cs228.hw1.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResellerTest{

    @Test
    public void testReseller(){
        Town town = new Town(5, 5);
        Reseller reseller = new Reseller(town, 0, 1);
        assertNotNull(reseller);
    }

    @Test
    public void testWho(){
        Town town = new Town(5, 5);
        Reseller reseller = new Reseller(town, 0, 1);
        assertEquals(reseller.who(), State.RESELLER);
    }

    @Test
    public void testNext(){
        Town oldtown = new Town(4, 4);
        Town newtown = new Town(4, 4);
        oldtown.randomInit(10);

        assertEquals(oldtown.grid[0][1].next(newtown).who(), State.EMPTY);
    }

}