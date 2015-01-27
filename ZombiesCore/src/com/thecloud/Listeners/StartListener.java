package com.thecloud.Listeners;

import com.thecloud.Core;
import com.thecloud.Structure.ChatUtilities;
import com.thecloud.Structure.GameState;
import com.thecloud.Structure.Start;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

public class StartListener implements Listener {

    private Core plugin;

    public StartListener(Core plugin) {
        this.plugin = plugin;
    }

    public static ArrayList<Player> onlinePlayers = new ArrayList<Player>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        onlinePlayers.add(p);
        e.setJoinMessage(ChatUtilities.tag()+ChatColor.GRAY + p.getName() + ChatColor.YELLOW + " joined the game!");
        if (onlinePlayers.size() == 2 && Start.countdowntime == 60) {
            ChatUtilities.broadcast("1 minute until the game starts!");
            plugin.startCountdown();
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (onlinePlayers.contains(p)) {
            onlinePlayers.remove(p);
        }
    }

}
