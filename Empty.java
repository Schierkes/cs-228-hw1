package edu.iastate.cs228.hw1;

public class Empty extends TownCell {

    public Empty(Town p, int r, int c) {
        super(p, r, c);
    }

    public State who(){
        return State.EMPTY;
    }

    public TownCell next(Town tNew) {

        census(nCensus);

        if (nCensus[EMPTY] + nCensus[OUTAGE] <= 1){
            return new Reseller(tNew, row, col);
        }
        else{
            return new Casual(tNew, row, col);
        }
    }
}