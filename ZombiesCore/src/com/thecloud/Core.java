package com.thecloud;

import com.thecloud.Commands.SetSpawn;
import com.thecloud.Listeners.Restrictions;
import com.thecloud.Listeners.StartListener;
import com.thecloud.Structure.FileManager;
import com.thecloud.Structure.GameState;
import com.thecloud.Structure.Start;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    public static int countdownID;

    public void onEnable() {
        FileManager.getInstance().setup(this);
        GameState.setGameState(GameState.IN_LOBBY);
        Bukkit.getPluginManager().registerEvents(new StartListener(this), this);
        Bukkit.getPluginManager().registerEvents(new Restrictions(), this);
        Bukkit.getPluginManager().addPermission(Restrictions.blockBreak);
        Bukkit.getPluginManager().addPermission(Restrictions.blockPlace);
        Bukkit.getPluginManager().addPermission(Restrictions.invClick);
        Bukkit.getPluginManager().addPermission(Restrictions.invOpen);
        getCommand("setspawn").setExecutor(new SetSpawn());
    }

    public void startCountdown() {
        countdownID = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Start(this), 0, 20);
    }

    public void stopCountdown() {
        Bukkit.getScheduler().cancelTask(countdownID);
    }
}
