package com.thecloud.Structure;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class SpawnManager {

    static FileManager settings = FileManager.getInstance();

    public static void teleportToSpawn(Player p) {
        String[] split = settings.getSpawns().getString("spawn").split(":");
        World w = Bukkit.getWorld(split[0]);
        double x = Double.parseDouble(split[1]);
        double y = Double.parseDouble(split[2]);
        double z = Double.parseDouble(split[3]);
        Location l = new Location(w, x, y, z);
        p.teleport(l);
    }

}
