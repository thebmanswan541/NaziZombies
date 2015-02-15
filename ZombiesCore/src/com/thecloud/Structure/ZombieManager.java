package com.thecloud.Structure;


import net.minecraft.server.v1_8_R1.AttributeInstance;
import net.minecraft.server.v1_8_R1.EntityInsentient;
import net.minecraft.server.v1_8_R1.EntityZombie;
import net.minecraft.server.v1_8_R1.GenericAttributes;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftZombie;
import org.bukkit.entity.*;
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
            LivingEntity live = zombie;
            ((EntityInsentient) ((CraftLivingEntity) live).getHandle()).getNavigation().a(FileManager.getInstance().getSpawns().getDouble("spawn.x"), FileManager.getInstance().getSpawns().getDouble("spawn.y"), FileManager.getInstance().getSpawns().getDouble("spawn.z"));
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
