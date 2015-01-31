package com.thecloud;

import com.thecloud.Structure.FileManager;
import com.thecloud.Structure.GameState;
import com.thecloud.Structure.EnableManager;
import com.thecloud.Structure.Start;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    public static int countdownID;
    EnableManager manager = new EnableManager();

    public void onEnable() {
        FileManager.getInstance().setup(this);
        GameState.setGameState(GameState.IN_LOBBY);
        manager.setup(this);
    }

    public void startCountdown() {
        countdownID = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Start(this), 0, 20);
    }

    public void stopCountdown() {
        Bukkit.getScheduler().cancelTask(countdownID);
    }
}
