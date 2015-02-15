package com.thecloud.Structure;

import com.thecloud.Core;
import com.thecloud.Listeners.StartListener;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class Start implements Runnable {

    private Core plugin;

    public Start(Core pl) {
        plugin = pl;
    }

    public static int countdowntime = 60;

    public void run() {
        if (countdowntime == 30) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
            }
            Utilities.broadcast("30 seconds until the game starts!");
        } else if (countdowntime == 0) {
            Utilities.startGame(plugin);
            return;
        } else if (countdowntime <= 10) {
            Utilities.broadcast(countdowntime + " seconds until the game starts!");
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
            }
        }

        for (Player p : Bukkit.getOnlinePlayers()) {
            Utilities.refreshStartScoreboard(p, plugin, countdowntime);
        }

        countdowntime--;
    }

}
