package com.thecloud.Listeners;

import com.thecloud.Core;
import com.thecloud.Structure.Utilities;
import com.thecloud.Structure.GameState;
import com.thecloud.Structure.Start;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
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

    Team t;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        p.getInventory().clear();
        p.setLevel(0);
        p.setExp(0);
        p.getActivePotionEffects().clear();

        Utilities.refreshStartScoreboard(p, plugin, 0);

        p.setGameMode(GameMode.ADVENTURE);

        e.setJoinMessage(Utilities.tag() + ChatColor.GRAY + p.getName() + " joined the game!");

        if (Bukkit.getOnlinePlayers().size() == 2 && Start.countdowntime == 60) {
            Utilities.broadcast("1 minute until the game starts!");
            for (Player pl : Bukkit.getOnlinePlayers()) {
                pl.playSound(pl.getLocation(), Sound.CLICK, 1, 1);
            }
            Utilities.cancelWaiting();
            plugin.startCountdown();
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        final Player p = e.getPlayer();

        if (GameState.isState(GameState.IN_LOBBY)) {
            Utilities.getStartBoard().getTeam("normal").removePlayer(p);
            if (Start.countdowntime < 60) {
                if (Bukkit.getOnlinePlayers().size() - 1 <= 1) {
                    Utilities.broadcast("Game start cancelled.");
                    Start.countdowntime = 60;
                    plugin.stopCountdown();
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            for (Player player : Bukkit.getOnlinePlayers()) {
                                Utilities.refreshStartScoreboard(player, plugin, 0);
                            }
                        }
                    }, 1);
                }
            }
        }
    }

}
