package com.thecloud.Structure;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class SpawnPoint {

    static FileManager settings = FileManager.getInstance();

    public static Location createSpawnPoint(String name) {
        World w = Bukkit.getWorld(settings.getSpawnPoints().getString("spawnpoints." + name + ".world"));
        double x = settings.getSpawnPoints().getDouble("spawnpoints."+name+".x");
        double y = settings.getSpawnPoints().getDouble("spawnpoints."+name+".y");
        double z = settings.getSpawnPoints().getDouble("spawnpoints."+name+".z");
        return new Location(w, x, y, z);
    }

    public static Location[] getNachtRoom1() {
        Location[] locs = new Location[] { createSpawnPoint("Nacht1"), createSpawnPoint("Nacht2"), createSpawnPoint("Nacht3"), createSpawnPoint("Nacht4"), createSpawnPoint("Nacht5") };
        return locs;
    }

    public static Location[] getNachtRoom3() {
        Location[] locs = new Location[] { createSpawnPoint("Nacht6"), createSpawnPoint("Nacht7"), createSpawnPoint("Nacht8"), createSpawnPoint("Nacht9") };
        return locs;
    }

    public static Location[] getNachtRoom2() {
        Location[] locs = new Location[] { createSpawnPoint("Nacht10"), createSpawnPoint("Nacht11"), createSpawnPoint("Nacht12") };
        return locs;
    }

    public static Door getNachtDoor1() {
        Door d = DoorManager.getInstance().getDoor("Nacht1");
        return d;
    }

    public static Door getNachtDoor2() {
        Door d = DoorManager.getInstance().getDoor("Nacht2");
        return d;
    }

    public static Door getNachtDoor3() {
        Door d = DoorManager.getInstance().getDoor("Nacht3");
        return d;
    }
}
