package com.thecloud.Listeners;

import com.thecloud.Core;
import com.thecloud.Structure.Start;
import org.bukkit.Bukkit;
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
        if (onlinePlayers.size() == 2 && Start.countdowntime == 60) {
            Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Start(), 0, 20);
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
