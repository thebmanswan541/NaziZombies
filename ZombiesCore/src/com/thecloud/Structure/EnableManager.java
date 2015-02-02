package com.thecloud.Structure;

import com.thecloud.Commands.SetSpawn;
import com.thecloud.Core;
import com.thecloud.Listeners.DamageHandler;
import com.thecloud.Listeners.Restrictions;
import com.thecloud.Listeners.RoundListener;
import com.thecloud.Listeners.StartListener;
import org.bukkit.Bukkit;

public class EnableManager {

    private Core plugin;

    public EnableManager() { }

    public void setup(Core plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(new ChatFormat(), plugin);
        Bukkit.getPluginManager().registerEvents(new DamageHandler(), plugin);
        Bukkit.getPluginManager().registerEvents(new Restrictions(), plugin);
        Bukkit.getPluginManager().registerEvents(new StartListener(plugin), plugin);
        Bukkit.getPluginManager().addPermission(Restrictions.invClick);
        Bukkit.getPluginManager().addPermission(Restrictions.invOpen);
        Bukkit.getPluginManager().addPermission(Restrictions.blockBreak);
        Bukkit.getPluginManager().addPermission(Restrictions.blockPlace);
        Bukkit.getPluginManager().registerEvents(new RoundListener(plugin), plugin);
        plugin.getCommand("setspawn").setExecutor(new SetSpawn());
    }

}
