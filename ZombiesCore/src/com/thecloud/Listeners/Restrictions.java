package com.thecloud.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.permissions.Permission;

public class Restrictions implements Listener{

    public static Permission blockBreak = new Permission("zombies.Block.Break");
    public static Permission blockPlace = new Permission("zombies.Block.Place");

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission(blockBreak)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission(blockPlace)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

}
