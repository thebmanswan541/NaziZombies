package com.thecloud.Structure;

import com.thecloud.Commands.SetMap;
import com.thecloud.Commands.SetSpawn;
import com.thecloud.Commands.SpawnPoints;
import com.thecloud.Core;
import com.thecloud.Listeners.*;
import org.bukkit.Bukkit;

public class EnableManager {

    private Core plugin;

    public EnableManager() { }

    FileManager settings = FileManager.getInstance();
    DoorManager doors = DoorManager.getInstance();

    public void setup(Core plugin) {
        this.plugin = plugin;
        settings.setup(plugin);
        doors.setup();
        Bukkit.getPluginManager().registerEvents(new CreateDoor(), plugin);
        Bukkit.getPluginManager().registerEvents(new OpenDoor(), plugin);
        Bukkit.getPluginManager().registerEvents(new ChatFormat(), plugin);
        Bukkit.getPluginManager().registerEvents(new DamageHandler(), plugin);
        Bukkit.getPluginManager().registerEvents(new Restrictions(), plugin);
        Bukkit.getPluginManager().registerEvents(new StartListener(plugin), plugin);
        Bukkit.getPluginManager().registerEvents(new RoundListener(plugin), plugin);
        Bukkit.getPluginManager().addPermission(Restrictions.invClick);
        Bukkit.getPluginManager().addPermission(Restrictions.invOpen);
        Bukkit.getPluginManager().addPermission(Restrictions.blockBreak);
        Bukkit.getPluginManager().addPermission(Restrictions.blockPlace);
        plugin.getCommand("setspawn").setExecutor(new SetSpawn());
        plugin.getCommand("spawnpoints").setExecutor(new SpawnPoints());
        plugin.getCommand("setmap").setExecutor(new SetMap());
    }

}
