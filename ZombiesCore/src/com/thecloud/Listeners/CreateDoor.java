package com.thecloud.Listeners;

import com.thecloud.Structure.Door;
import com.thecloud.Structure.DoorManager;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class CreateDoor implements Listener{

    private String s;
    ArrayList<Player> door;

    @EventHandler
    public void onSign(SignChangeEvent e) {
        Player p = e.getPlayer();
        for (int i = 0; i < e.getLines().length; i++) {
            if (e.getLine(i).toLowerCase().contains("door")) {
                door.add(p);
                p.sendMessage(ChatColor.GREEN+"Please left click this sign to make it door!");
            }
        }
    }

    @EventHandler
    public void onInt(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (door.contains(p)) {
            if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
                Block b = e.getClickedBlock();
                if (b.getState() instanceof Sign) {
                    Sign s = (Sign) b.getState();
                    DoorManager.getInstance().addDoor(new Door(s.getLine(0), s.getWorld().getName()+":"+s.getLocation().getX()+":"+s.getLocation().getY()+":"+s.getLocation().getZ(), Integer.parseInt(s.getLine(1))));
                    Door d = DoorManager.getInstance().getDoor(s.getLine(0));
                    s.setLine(0, null); s.setLine(1, ChatColor.RED+""+d.getCost());
                    p.sendMessage(ChatColor.GREEN+"Door created!");
                }
            }
        }
    }
}
