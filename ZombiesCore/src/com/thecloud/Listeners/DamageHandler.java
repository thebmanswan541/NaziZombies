package com.thecloud.Listeners;

import com.thecloud.Structure.Credits;
import com.thecloud.Structure.GameState;
import com.thecloud.Structure.Utilities;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class DamageHandler implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (GameState.isState(GameState.IN_LOBBY)) {
            e.setCancelled(true);
            return;
        }
        if (e.getDamager() instanceof Player) {
            Player p = (Player) e.getDamager();
            if (e.getEntity() instanceof Zombie) {
                Credits.addCredits(p, 10);
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    Utilities.refreshScoreboard(pl);
                }
                if (p.getItemInHand().getType() == Material.IRON_SWORD) {
                    e.setDamage(75D);
                }
            }
        } else if (e.getDamager() instanceof Zombie && e.getEntity() instanceof Player) {
            e.setDamage(8D);
        }
    }

    @EventHandler
    public void onKill(EntityDeathEvent e) {
        if (e.getEntity() instanceof Zombie) {
            Credits.addCredits(e.getEntity().getKiller(), 50);
            for (Player pl : Bukkit.getOnlinePlayers()) {
                Utilities.refreshScoreboard(pl);
            }
        }
    }

}
