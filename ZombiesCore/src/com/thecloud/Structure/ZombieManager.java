package com.thecloud.Structure;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

import java.util.List;

public class ZombieManager {

    public static void createZombieSpawnChain(List<Player> players, Location location, int numZombies, double health) {
        World world = null;
        for (Player player : players) {
            world = player.getWorld();
        }
        for (int i = 0; i < numZombies; i++) {
            Zombie zombie = Bukkit.getWorld(world.getName()).spawn(location, Zombie.class);
            zombie.setMaxHealth(health);
            zombie.setHealth(health);
        }
    }

    public static int getZombiesLeft(World w) {
        int amount = 0;
        for (Entity en : w.getEntities()) {
            if (en instanceof Zombie) {
                amount++;
            }
        }
        return amount;
    }



}
