package com.thecloud.Structure;

import com.thecloud.Listeners.StartListener;
import net.minecraft.server.v1_8_R1.*;
import org.bukkit.*;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.*;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.*;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
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
        Location l = new Location(w, x, y, z, yaw, pitch);
        p.teleport(l);
    }

    private static Scoreboard board;

    public static void refreshScoreboard(Player p) {
        board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective o = board.registerNewObjective("Credits", "dummy");
        o.setDisplayName(ChatColor.RED+"Credits");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);

        Team t = board.getTeam("Yellow");
        Team t1 = board.getTeam("Blue");
        Team t2 = board.getTeam("White");
        Team t3 = board.getTeam("Green");

        if (t == null) {
            t = board.registerNewTeam("Yellow");
        }
        if (t1 == null) {
            t1 = board.registerNewTeam("Blue");
        }
        if (t2 == null) {
            t2 = board.registerNewTeam("White");
        }
        if (t3 == null) {
            t3 = board.registerNewTeam("Green");
        }

        for (Player player : StartListener.onlinePlayers) {
            Score s = o.getScore(player.getDisplayName());
            s.setScore(Credits.getCredits(player));
            if (t2.getSize() < 1) {
                t2.addPlayer(player);
            } else if (t.getSize() < 1) {
                t.addPlayer(player);
            } else if (t3.getSize() < 1) {
                t3.addPlayer(player);
            } else if (t1.getSize() < 1) {
                t1.addPlayer(player);
            }
        }
        t.setPrefix("§e");
        t1.setPrefix("§b");
        t2.setPrefix("§f");
        t3.setPrefix("§a");
        p.setScoreboard(board);
    }

    public static Scoreboard getBoard() {
        return board;
    }

    public static void breakDoor(Location signLocation) {
        Location[] locations = new Location[] { new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY(), signLocation.getZ()), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY(), signLocation.getZ()), new Location(signLocation.getWorld(), signLocation.getX(), signLocation.getY(), signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX(), signLocation.getY(), signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY(), signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY(), signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY(), signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY(), signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY()+1, signLocation.getZ()), new Location(signLocation.getWorld(), signLocation.getX(), signLocation.getY()+1, signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY()+1, signLocation.getZ()), new Location(signLocation.getWorld(), signLocation.getX(), signLocation.getY()+1, signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY()+1, signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY()+1, signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY()+1, signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY()+1, signLocation.getZ()-1) };
        ArrayList<Block> blocks = new ArrayList<Block>();
        for (Location loc : locations) {
            if (loc.getBlock().getType() == Material.GLASS) {
                blocks.add(loc.getBlock());
            }
        }
        for (Block b : blocks) {
            b.breakNaturally();
            b.getDrops().clear();
        }
    }
}
