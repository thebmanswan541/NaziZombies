package com.thecloud;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import com.thecloud.Structure.*;

public class Core extends JavaPlugin {

    public static int countdownID;
    EnableManager manager = new EnableManager();

    public void onEnable() {
        GameState.setGameState(GameState.IN_LOBBY);
        manager.setup(this);
        for (Door d : DoorManager.getInstance().getDoors()) {
            d.setUnlocked(false);
        }
    }
    public void startCountdown() {
        countdownID = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Start(this), 0, 20);
    }

    public void stopCountdown() {
        Bukkit.getScheduler().cancelTask(countdownID);
    }
}
