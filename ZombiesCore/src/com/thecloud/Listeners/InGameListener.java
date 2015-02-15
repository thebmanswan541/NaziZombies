package com.thecloud.Listeners;

import com.thecloud.Structure.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class InGameListener implements Listener{

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if (GameState.isState(GameState.IN_GAME)) {

        }
    }

}
