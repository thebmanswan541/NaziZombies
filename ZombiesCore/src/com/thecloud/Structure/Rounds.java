package com.thecloud.Structure;

public class Rounds {

    private int round = 1;

    private Rounds() {  }

    static Rounds instance;

    //Gets the rounds class
    public static Rounds getInstance() {
        return instance;
    }

    //Increments the round by 1
    public void addRound() {
        round++;
    }

    //Retrieves the round number
    public int getRound() {
        return round;
    }

}
