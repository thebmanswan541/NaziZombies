package com.thecloud.Structure;

import com.thecloud.Core;
import com.thecloud.Listeners.StartListener;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Start implements Runnable {

    private Core plugin;

    public Start(Core pl) {
        plugin = pl;
    }

    public static int countdowntime = 60;

    public void run() {
        if (countdowntime == 30) {
            ChatUtilities.broadcast("30 seconds until the game starts!");
        } else if (countdowntime == 0) {
            plugin.stopCountdown();
            GameState.setGameState(GameState.IN_GAME);
            for (Player player : StartListener.onlinePlayers) {
                Credits.setCredits(player, 500);
                player.getInventory().addItem(Items.createItem(Material.IRON_SWORD, 1, ChatColor.GRAY+"Knife", null));
                player.getInventory().addItem(Items.createItem(Material.WOOD_SPADE, 1, null, null));
                player.getInventory().setItem(9, Items.createItem(Material.WHEAT, 40, ChatColor.GRAY+"Colt M1911 Ammunition", null));
                SpawnManager.teleportToSpawn(player);
            }
        } else if (countdowntime <= 10) {
            ChatUtilities.broadcast(countdowntime+" seconds until the game starts!");
        }

        countdowntime--;
    }

}
