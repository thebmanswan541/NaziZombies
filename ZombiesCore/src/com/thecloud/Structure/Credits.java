package com.thecloud.Structure;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Credits {

    private static HashMap<Player, Integer> credits = new HashMap<Player, Integer>();

    public static Integer getCredits(Player player) {
        return credits.get(player);
    }

    public static void addCredits(Player player, int amount) {
        credits.put(player, credits.get(player)+amount);
    }

    public static void setCredits(Player player, int amount) {
        credits.put(player, amount);
    }

}
