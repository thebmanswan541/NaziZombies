package com.thecloud.Structure;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/**
 * Created by Mitchell on 1/25/2015.
 */
public class ChatUtilities {

    public static void broadcast(String message) {
        Bukkit.broadcastMessage(ChatColor.DARK_GRAY+"["+ChatColor.DARK_GREEN+"Zombies"+ChatColor.DARK_GRAY+"]"+ChatColor.GRAY+": "+ChatColor.RESET+message);
    }

}
