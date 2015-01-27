package com.thecloud.Structure;

import com.thecloud.Listeners.StartListener;
import org.bukkit.ChatColor;

public class Start implements Runnable {

    public static int countdowntime = 60;

    public void run() {
        if (StartListener.onlinePlayers.size() <= 1) {
            ChatUtilities.broadcast("Game start cancelled.");
            countdowntime = 60;
        }

        if (countdowntime == 30) {
            ChatUtilities.broadcast("30 seconds until the game starts!");
        } else if (countdowntime == 0) {

        } else if (countdowntime <= 10 && countdowntime != 0) {
            ChatUtilities.broadcast(countdowntime+" seconds until the game starts!");
        }

        countdowntime--;
    }

}
