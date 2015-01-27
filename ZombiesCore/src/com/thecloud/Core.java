package com.thecloud;

import com.thecloud.Listeners.StartListener;
import com.thecloud.Structure.GameState;
import com.thecloud.Structure.Start;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    public static int countdownID;

    public void onEnable() {
        GameState.setGameState(GameState.IN_LOBBY);
        Bukkit.getPluginManager().registerEvents(new StartListener(this), this);
    }

    public void startCountdown() {
        countdownID = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Start(this), 0, 20);
    }

    public void stopCountdown() {
        Bukkit.getScheduler().cancelTask(countdownID);
    }
}
