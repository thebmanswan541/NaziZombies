package com.thecloud;

import com.thecloud.Listeners.StartListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new StartListener(this), this);
    }

}
