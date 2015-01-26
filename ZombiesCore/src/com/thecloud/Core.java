package com.thecloud;

import com.thecloud.Listeners.Joining;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new Joining(), this);
    }

}
