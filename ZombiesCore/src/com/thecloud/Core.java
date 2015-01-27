package com.thecloud;

import com.thecloud.Listeners.StartListener;
import com.thecloud.Structure.GameState;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    public void onEnable() {
        GameState.setGameState(GameState.IN_LOBBY);
        Bukkit.getPluginManager().registerEvents(new StartListener(this), this);
    }

}
