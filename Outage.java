package edu.iastate.cs228.hw1;

public class Outage extends TownCell {

    public Outage(Town p, int r, int c) {
        super(p, r, c);
    }

    public State who(){
        return State.OUTAGE;
    }

    public TownCell next(Town tNew) {
        return new Empty(tNew, row, col);
    }
}