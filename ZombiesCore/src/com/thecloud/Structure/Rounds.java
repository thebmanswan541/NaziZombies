package com.thecloud.Structure;

import org.bukkit.entity.Player;

public class Rounds {

    private static int round = 1;

    //Increments the round by 1
    public static void addRound() {
        round++;
    }

    //Retrieves the round number
    public static int getRound() {
        return round;
    }

}
