package com.thecloud.Structure;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormat implements Listener{

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (Utilities.getStartBoard().getPlayerTeam(p) != null) {
            e.setFormat(Utilities.getStartBoard().getPlayerTeam(p).getPrefix() + p.getDisplayName() + ChatColor.GRAY+": " + ChatColor.RESET + e.getMessage());
        } else {
            e.setFormat(Utilities.getBoard().getPlayerTeam(p).getPrefix()+p.getDisplayName()+ChatColor.GRAY+": "+ChatColor.RESET+e.getMessage());
        }
    }

}
