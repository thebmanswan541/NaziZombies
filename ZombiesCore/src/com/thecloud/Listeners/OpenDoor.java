package com.thecloud.Listeners;

import com.thecloud.Core;
import com.thecloud.Structure.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.scoreboard.Score;

import java.nio.charset.CoderResult;
import java.util.List;

public class OpenDoor implements Listener{

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (GameState.isState(GameState.IN_GAME)) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Block b = e.getClickedBlock();
                if (b.getState() instanceof Sign) {
                    Sign s = (Sign) b.getState();
                    String location = s.getWorld().getName()+":"+s.getLocation().getX()+":"+s.getLocation().getY()+":"+s.getLocation().getZ();
                    for (Door d : DoorManager.getInstance().getDoors()) {
                        if (d.getLocation().equals(location)) {
                            if (Credits.getCredits(p) >= d.getCost()) {
                                Credits.addCredits(p, -d.getCost());
                                for (Player pl : StartListener.onlinePlayers) {
                                    Utilities.refreshScoreboard(pl);
                                }
                                Utilities.breakDoor(s.getLocation());
                            } else {
                                p.sendMessage(ChatColor.RED+"You do not have enough credits to do this.");
                            }
                        }
                    }
                }
            }
        }
    }

}
