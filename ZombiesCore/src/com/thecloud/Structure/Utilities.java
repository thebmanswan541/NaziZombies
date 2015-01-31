package com.thecloud.Structure;

import net.minecraft.server.v1_7_R4.ChatModifier;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PlayerConnection;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.spigotmc.ProtocolInjector;

import java.util.List;

public class Utilities {

    static FileManager settings = FileManager.getInstance();

    public static String tag() {
        return ChatColor.DARK_GRAY+"["+ChatColor.DARK_GREEN+"Zombies"+ChatColor.DARK_GRAY+"]"+ChatColor.GRAY+": ";
    }

    public static void broadcast(String message) {
        Bukkit.broadcastMessage(ChatColor.DARK_GRAY+"["+ChatColor.DARK_GREEN+"Zombies"+ChatColor.DARK_GRAY+"]"+ChatColor.GRAY+": "+message);
    }

    public static ItemStack createItem(Material m, int amount, String name, List<String> lore) {
        ItemStack im = new ItemStack(m, amount); {
            ItemMeta meta = im.getItemMeta();
            meta.setDisplayName(name);
            meta.setLore(lore);
            im.setItemMeta(meta);
        }
        return im;
    }

    public static void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        CraftPlayer p = (CraftPlayer) player;
        PlayerConnection connection = p.getHandle().playerConnection;
        IChatBaseComponent titleJSON = ChatSerializer.a("{'text': '"+ChatColor.translateAlternateColorCodes('&', title)+"'}");
        IChatBaseComponent subtitleJSON = ChatSerializer.a("{'text': '"+ChatColor.translateAlternateColorCodes('&', subtitle)+"'}");
        connection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TIMES, fadeIn, stay, fadeOut));
        connection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TITLE, titleJSON));
        connection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.SUBTITLE, subtitleJSON));
    }

    public static void teleportToSpawn(Player p) {
        World w = Bukkit.getWorld(settings.getSpawns().getString("spawn.world"));
        double x = settings.getSpawns().getDouble("spawn.x");
        double y = settings.getSpawns().getDouble("spawn.y");
        double z = settings.getSpawns().getDouble("spawn.z");
        Location l = new Location(w, x, y, z);
        p.teleport(l);
    }

}
