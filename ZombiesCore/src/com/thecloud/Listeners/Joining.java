package com.thecloud.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;

public class Joining implements Listener{

    public static ArrayList<Player> onlinePlayers = new ArrayList<Player>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        onlinePlayers.add(p);
    }

}
