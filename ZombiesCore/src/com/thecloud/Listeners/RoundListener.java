package com.thecloud.Listeners;

import com.thecloud.Core;
import com.thecloud.NachtDerUntoten.NachtSpawnManager;
import com.thecloud.Structure.*;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
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
        if (e.getEntity().getType() == EntityType.ZOMBIE) {
            if (GameState.isState(GameState.IN_GAME)) {
                if (ZombieManager.getZombiesLeft(e.getEntity().getWorld())-1 <= 0) {
                    Rounds.addRound();
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.playSound(pl.getLocation(), Sound.SKELETON_DEATH, 1, 1);
                    }
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                Utilities.sendTitle(pl, ChatColor.RED + "Round " + Rounds.getRound(), null, 20, 60, 20);
                                pl.playSound(pl.getLocation(), Sound.CREEPER_DEATH, 1, 1);
                                pl.setLevel(Rounds.getRound());
                            }
                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                public void run() {
                                    if (Rounds.getRound() == 2) {
                                        NachtSpawnManager.spawnRound2();
                                    } else if (Rounds.getRound() == 3) {
                                        NachtSpawnManager.spawnRound3();
                                    } else if (Rounds.getRound() == 4) {
                                        NachtSpawnManager.spawnRound4();
                                    } else if (Rounds.getRound() == 5) {
                                        NachtSpawnManager.spawnRound5();
                                    } else if (Rounds.getRound() == 6) {
                                        NachtSpawnManager.spawnRound6();
                                    } else if (Rounds.getRound() == 7) {
                                        NachtSpawnManager.spawnRound7();
                                    } else if (Rounds.getRound() == 8) {
                                        NachtSpawnManager.spawnRound8();
                                    } else if (Rounds.getRound() == 9) {
                                        NachtSpawnManager.spawnRound9();
                                    } else if (Rounds.getRound() == 10) {
                                        NachtSpawnManager.spawnRound10();
                                    }
                                }
                            }, 200);
                        }
                    }, 400);
                }
            }
        }
    }

}
