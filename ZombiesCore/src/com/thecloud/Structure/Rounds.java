package com.thecloud.Structure;

public class Rounds {

    private int round = 1;

    private Rounds() {  }

    static Rounds instance;

    public static Rounds getInstance() {
        return instance;
    }

    public void addRound() {
        round++;
    }

    public int getRound() {
        return round;
    }

}
