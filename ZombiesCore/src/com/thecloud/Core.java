package com.thecloud;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener{

    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

}
