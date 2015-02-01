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
            Utilities.broadcast("30 seconds until the game starts!");
        } else if (countdowntime == 10) {
            Utilities.broadcast("10 seconds until the game starts!");
        } else if (countdowntime == 0) {
            plugin.stopCountdown();
            GameState.setGameState(GameState.IN_GAME);
            Bukkit.getScoreboardManager().getMainScoreboard().getTeam("normal").unregister();
            for (Player player : StartListener.onlinePlayers) {
                player.getInventory().clear();
                Credits.setCredits(player, 500);
                player.getInventory().addItem(Utilities.createItem(Material.IRON_SWORD, 1, ChatColor.GRAY + "Knife", null));
                player.getInventory().addItem(Utilities.createItem(Material.WOOD_SPADE, 1, null, null));
                player.getInventory().setItem(9, Utilities.createItem(Material.WHEAT, 40, ChatColor.GRAY + "Colt M1911 Ammunition", null));
                Utilities.teleportToSpawn(player);
                player.setLevel(Rounds.getRound());
                Utilities.sendTitle(player, ChatColor.RED + "Round " + Rounds.getRound(), null, 20, 60, 20);
            }

            World w = Bukkit.getWorld(FileManager.getInstance().getSpawns().getString("spawn.world"));
            Location loc = new Location(w, FileManager.getInstance().getSpawns().getDouble("spawn.x"), FileManager.getInstance().getSpawns().getDouble("spawn.y"), FileManager.getInstance().getSpawns().getDouble("spawn.z"));
            loc.getWorld().playSound(loc, Sound.CREEPER_DEATH, 1, 1);

            for (Player player : StartListener.onlinePlayers) {
                Utilities.refreshScoreboard(player);
            }
        } else if (countdowntime <= 5) {
            Utilities.broadcast(countdowntime + " seconds until the game starts!");
        }

        countdowntime--;
    }

}
