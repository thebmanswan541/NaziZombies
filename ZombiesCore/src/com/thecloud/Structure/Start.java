package com.thecloud.Structure;

import com.thecloud.Core;
import com.thecloud.Listeners.StartListener;
import org.bukkit.entity.Player;

public class Start implements Runnable {

    private Core plugin;

    public Start(Core pl) {
        plugin = pl;
    }

    public static int countdowntime = 60;

    public void run() {
        if (StartListener.onlinePlayers.size() <= 1) {
            ChatUtilities.broadcast("Game start cancelled.");
            countdowntime = 60;
        }

        if (countdowntime == 30) {
            ChatUtilities.broadcast("30 seconds until the game starts!");
        } else if (countdowntime == 0) {
            plugin.stopCountdown();
            GameState.setGameState(GameState.IN_GAME);
            for (Player player : StartListener.onlinePlayers) {
                Credits.setCredits(player, 500);
            }
        } else if (countdowntime <= 10 && countdowntime != 0) {
            ChatUtilities.broadcast(countdowntime+" seconds until the game starts!");
        }
        countdowntime--;
    }

}
