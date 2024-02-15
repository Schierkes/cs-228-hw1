package edu.iastate.cs228.hw1.test;

import edu.iastate.cs228.hw1.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StreamerTest{

    @Test
    public void testStreamer(){
        Town town = new Town(5, 5);
        Streamer streamer = new Streamer(town, 0, 1);
        assertNotNull(streamer);
    }

    @Test
    public void testWho(){
        Town town = new Town(5, 5);
        Streamer streamer = new Streamer(town, 0, 1);
        assertEquals(streamer.who(), State.STREAMER);
    }

    @Test
    public void testNext(){
        Town oldtown = new Town(4, 4);
        Town newtown = new Town(4, 4);
        oldtown.randomInit(10);

        assertEquals(oldtown.grid[2][1].next(newtown).who(), State.OUTAGE);
    }

}