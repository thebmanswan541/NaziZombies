package com.thecloud.Listeners;

import com.thecloud.Core;
import com.thecloud.Structure.Utilities;
import com.thecloud.Structure.GameState;
import com.thecloud.Structure.Start;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;

public class StartListener implements Listener {

    private Core plugin;

    public StartListener(Core plugin) {
        this.plugin = plugin;
    }

    public static ArrayList<Player> onlinePlayers = new ArrayList<Player>();

    Team t;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        p.setGameMode(GameMode.ADVENTURE);

        if (Bukkit.getScoreboardManager().getMainScoreboard().getTeam("normal") == null) {
            t = Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam("normal");
            t.setPrefix("§7");
        }

        t.addPlayer(p);

        onlinePlayers.add(p);

        e.setJoinMessage(Utilities.tag()+ChatColor.GRAY + p.getName() + " joined the game!");

        if (onlinePlayers.size() == 2 && Start.countdowntime == 60) {
            Utilities.broadcast("1 minute until the game starts!");
            plugin.startCountdown();
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        if (Bukkit.getScoreboardManager().getMainScoreboard().getTeam("normal") != null) {
            if (Bukkit.getScoreboardManager().getMainScoreboard().getTeam("normal").hasPlayer(p)) {
                t.removePlayer(p);
            }
        }

        if (onlinePlayers.contains(p)) {
            onlinePlayers.remove(p);
        }

        if (GameState.isState(GameState.IN_LOBBY)) {
            if (StartListener.onlinePlayers.size() <= 1) {
                Utilities.broadcast("Game start cancelled.");
                Start.countdowntime = 60;
                plugin.stopCountdown();
            }
        }
    }

}
