package com.thecloud.Listeners;

import com.thecloud.Core;
import com.thecloud.Structure.Rounds;
import com.thecloud.Structure.Utilities;
import com.thecloud.Structure.ZombieManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class RoundListener implements Listener{

    private Core plugin;

    public RoundListener(Core plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        if (e.getEntity() instanceof Zombie) {
            if (ZombieManager.getZombiesLeft(e.getEntity().getKiller().getWorld())-1 <= 0) {
                Rounds.addRound();
                for (Player pl : StartListener.onlinePlayers) {
                    pl.getWorld().playSound(pl.getLocation(), Sound.BAT_DEATH, 1, 1);
                }
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run() {
                        for (Player pl : StartListener.onlinePlayers) {
                            Utilities.sendTitle(pl, ChatColor.RED + "Round " + Rounds.getRound(), null, 20, 60, 20);
                            pl.getWorld().playSound(pl.getLocation(), Sound.CREEPER_DEATH, 1, 1);
                            pl.setLevel(Rounds.getRound());
                        }
                    }
                }, 400);
            }
        }
    }

}
