package com.thecloud.Listeners;

import com.thecloud.Structure.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.permissions.Permission;

public class Restrictions implements Listener{

    public static Permission blockBreak = new Permission("zombies.Block.Break");
    public static Permission blockPlace = new Permission("zombies.Block.Place");
    public static Permission invClick = new Permission("zombies.Inventory.Click");
    public static Permission invOpen = new Permission("zombies.Inventory.Open");

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

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (p.hasPermission(invClick)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onOpenInv(InventoryOpenEvent e) {
        Player p = (Player) e.getPlayer();
        if (p.hasPermission(invOpen)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if (!GameState.isState(GameState.IN_LOBBY)) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

}
