package com.thecloud.Listeners;

import com.thecloud.Core;
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
            Zombie zombie = (Zombie) e.getEntity();

        }
    }

}
