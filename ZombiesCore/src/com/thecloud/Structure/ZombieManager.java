package com.thecloud.Structure;


import net.minecraft.server.v1_8_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftZombie;
import org.bukkit.entity.*;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

public class ZombieManager {

    public static void createZombieSpawnChain(Location location, int numZombies, double health, double speed) {
        World world = null;
        for (Player player : Bukkit.getOnlinePlayers()) {
            world = player.getWorld();
        }
        for (int i = 0; i < numZombies; i++) {
            Zombie zombie = Bukkit.getWorld(world.getName()).spawn(location, Zombie.class);
            zombie.setMaxHealth(health);
            zombie.setHealth(health);
            zombie.setBaby(false);
            zombie.setVillager(false);
            zombie.getEquipment().clear();
            zombie.getEquipment().setHelmet(new ItemStack(Material.INK_SACK));
            EntityZombie z = ((CraftZombie) zombie).getHandle();
            AttributeInstance attributeInstance = z.getAttributeInstance(GenericAttributes.d);
            AttributeInstance attributeInstance1 = z.getAttributeInstance(GenericAttributes.b);
            attributeInstance.setValue(speed);
            attributeInstance1.setValue(70.0D);
        }
    }

    public static int getZombiesLeft(World w) {
        int amount = 0;
        for (Entity en : w.getEntities()) {
            if (en.getType() == EntityType.ZOMBIE) {
                amount++;
            }
        }
        return amount;
    }

}
