package com.thecloud.Structure;

import com.thecloud.Core;
import com.thecloud.Listeners.StartListener;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Start implements Runnable {

    private Core plugin;

    public Start(Core pl) {
        plugin = pl;
    }

    public static int countdowntime = 60;

    public void run() {
        if (countdowntime == 30) {
            Utilities.broadcast("30 seconds until the game starts!");
        } else if (countdowntime == 0) {
            plugin.stopCountdown();
            GameState.setGameState(GameState.IN_GAME);
            for (Player player : StartListener.onlinePlayers) {
                Credits.setCredits(player, 500);
                player.getInventory().addItem(Utilities.createItem(Material.IRON_SWORD, 1, ChatColor.GRAY + "Knife", null));
                player.getInventory().addItem(Utilities.createItem(Material.WOOD_SPADE, 1, null, null));
                player.getInventory().setItem(9, Utilities.createItem(Material.WHEAT, 40, ChatColor.GRAY + "Colt M1911 Ammunition", null));
                SpawnManager.teleportToSpawn(player);
                Utilities.sendTitle(player, ChatColor.RED+"Round "+Rounds.getRound(), ChatColor.GREEN+"Nazi Zombies", 20, 30, 20);
            }
        } else if (countdowntime <= 10) {
            Utilities.broadcast(countdowntime + " seconds until the game starts!");
        }

        countdowntime--;
    }

}
