package com.thecloud.Structure;

import com.thecloud.Listeners.StartListener;
import net.minecraft.server.v1_8_R1.*;
import org.bukkit.*;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.*;
import org.bukkit.scoreboard.Scoreboard;

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
        IChatBaseComponent titleJSON = ChatSerializer.a("{'text': '" + ChatColor.translateAlternateColorCodes('&', title) + "'}");
        if (subtitle == null) {
            connection.sendPacket(new PacketPlayOutTitle(fadeIn, stay, fadeOut));
            connection.sendPacket(new PacketPlayOutTitle(EnumTitleAction.TITLE, titleJSON));
        } else {
            IChatBaseComponent subtitleJSON = ChatSerializer.a("{'text': '" + ChatColor.translateAlternateColorCodes('&', subtitle) + "'}");
            connection.sendPacket(new PacketPlayOutTitle(fadeIn, stay, fadeOut));
            connection.sendPacket(new PacketPlayOutTitle(EnumTitleAction.TITLE, titleJSON));
            connection.sendPacket(new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, subtitleJSON));
        }
    }

    public static void teleportToSpawn(Player p) {
        World w = Bukkit.getWorld(settings.getSpawns().getString("spawn.world"));
        double x = settings.getSpawns().getDouble("spawn.x");
        double y = settings.getSpawns().getDouble("spawn.y");
        double z = settings.getSpawns().getDouble("spawn.z");
        int pitch = settings.getSpawns().getInt("spawn.pitch");
        int yaw = settings.getSpawns().getInt("spawn.yaw");
        Location l = new Location(w, x, y, z, pitch, yaw);
        p.teleport(l);
    }

    public static void refreshScoreboard(Player p) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective o = scoreboard.registerNewObjective("Credits", "dummy");
        o.setDisplayName(ChatColor.RED+"Credits");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);

        Team t = scoreboard.getTeam("Gold");

        if (t == null) {
            t = scoreboard.registerNewTeam("Gold");
        }

        for (Player player : StartListener.onlinePlayers) {
            Score s = o.getScore(player.getDisplayName());
            s.setScore(Credits.getCredits(player));
            t.addPlayer(player);
        }
        t.setPrefix("§6");
        p.setScoreboard(scoreboard);
    }

}
