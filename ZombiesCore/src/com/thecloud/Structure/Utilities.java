package com.thecloud.Structure;

import com.thecloud.Core;
import com.thecloud.Listeners.StartListener;
import com.thecloud.NachtDerUntoten.SpawnManager;
import net.minecraft.server.v1_8_R1.*;
import org.bukkit.*;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.*;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.LivingEntity;
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

    public static String getMap() {
        return settings.getConfig().getString("map");
    }

    public static Location getSpawn() {
        World w = Bukkit.getWorld(settings.getSpawns().getString("spawn.world"));
        double x = settings.getSpawns().getDouble("spawn.x");
        double y = settings.getSpawns().getDouble("spawn.y");
        double z = settings.getSpawns().getDouble("spawn.z");
        int pitch = settings.getSpawns().getInt("spawn.pitch");
        int yaw = settings.getSpawns().getInt("spawn.yaw");
        return new Location(w, x, y, z, yaw, pitch);
    }

    public static void teleportToSpawn(Player p) {
        p.teleport(getSpawn());
    }

    private static Scoreboard board;
    private static Scoreboard startBoard;
    static int waitingID;

    public static void cancelWaiting() {
        Bukkit.getScheduler().cancelTask(waitingID);
    }

    public static void refreshStartScoreboard(Player p, Core plugin, int timeLeft) {
        startBoard = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective o = startBoard.registerNewObjective("Starting", "dummy");
        o.setDisplayName(ChatColor.RED+"Nazi "+ChatColor.DARK_GREEN+"Zombies");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);

        Team t = startBoard.getTeam("normal");

        if (t == null) {
            t = startBoard.registerNewTeam("normal");
        }

        Score s = o.getScore("§1"); s.setScore(1);
        if (Bukkit.getOnlinePlayers().size() >= 2) {
            Score s1 = o.getScore("Starting in "+ChatColor.GREEN+timeLeft+"s");
            s1.setScore(2);
        } else {
            waitingID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                int index = 0;
                Score s1;
                public void run() {
                    index++;
                    if (index == 1) {
                        if (o.getScore("Waiting...") != null) {
                            o.getScoreboard().resetScores("Waiting...");
                        }
                        s1 = o.getScore("Waiting");
                        s1.setScore(2);
                    } else if (index == 2) {
                        o.getScoreboard().resetScores("Waiting");
                        s1 = o.getScore("Waiting.");
                        s1.setScore(2);
                    } else if (index == 3) {
                        o.getScoreboard().resetScores("Waiting.");
                        s1 = o.getScore("Waiting..");
                        s1.setScore(2);
                    } else if (index == 4) {
                        index = 0;
                        o.getScoreboard().resetScores("Waiting..");
                        s1 = o.getScore("Waiting...");
                        s1.setScore(2);
                    }
                }
            }, 1, 17);
        }
        Score s2 = o.getScore("§2"); s2.setScore(3);
        Score s3 = o.getScore("Players: "+ChatColor.GREEN+Bukkit.getOnlinePlayers().size()+"/"+Bukkit.getMaxPlayers()); s3.setScore(4);
        Score s4 = o.getScore("Map: "+ChatColor.GREEN+getMap()); s4.setScore(5);
        Score s5 = o.getScore("§3"); s5.setScore(6);

        for (Player player : Bukkit.getOnlinePlayers()) {
            t.addPlayer(player);
        }

        t.setPrefix("§7");
        p.setScoreboard(startBoard);
    }

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

        for (Player player : Bukkit.getOnlinePlayers()) {
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

    public static Scoreboard getStartBoard() {
        return startBoard;
    }

    public static void startGame(Core plugin) {
        plugin.stopCountdown();
        GameState.setGameState(GameState.IN_GAME);
        getStartBoard().getTeam("normal").unregister();
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
            player.getInventory().clear();
            Credits.setCredits(player, 500);
            player.getInventory().addItem(createItem(Material.IRON_SWORD, 1, ChatColor.GRAY + "Knife", null));
            player.getInventory().addItem(createItem(Material.WOOD_SPADE, 1, null, null));
            player.getInventory().setItem(9, createItem(Material.WHEAT, 40, ChatColor.GRAY + "Colt M1911 Ammunition", null));
            teleportToSpawn(player);
            player.getInventory().setHeldItemSlot(1);
            player.setLevel(Rounds.getRound());
            sendTitle(player, ChatColor.RED + "Round " + Rounds.getRound(), null, 20, 60, 20);
        }

        World w = Bukkit.getWorld(FileManager.getInstance().getSpawns().getString("spawn.world"));
        Location loc = new Location(w, FileManager.getInstance().getSpawns().getDouble("spawn.x"), FileManager.getInstance().getSpawns().getDouble("spawn.y"), FileManager.getInstance().getSpawns().getDouble("spawn.z"));
        loc.getWorld().playSound(loc, Sound.CREEPER_DEATH, 1, 1);

        for (Player player : Bukkit.getOnlinePlayers()) {
            refreshScoreboard(player);
        }
        if (getMap().equals("Nacht Der Untoten")) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    SpawnManager.spawnRound1();
                }
            }, 200);
        }
    }

    public static void breakDoor(Location signLocation) {
        Location[] locations = new Location[] { new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY(), signLocation.getZ()), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY(), signLocation.getZ()), new Location(signLocation.getWorld(), signLocation.getX(), signLocation.getY(), signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX(), signLocation.getY(), signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY(), signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY(), signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY(), signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY(), signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY()+1, signLocation.getZ()), new Location(signLocation.getWorld(), signLocation.getX(), signLocation.getY()+1, signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY()+1, signLocation.getZ()), new Location(signLocation.getWorld(), signLocation.getX(), signLocation.getY()+1, signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY()+1, signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY()+1, signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY()+1, signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY()+1, signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY()+2, signLocation.getZ()), new Location(signLocation.getWorld(), signLocation.getX(), signLocation.getY()+2, signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY()+2, signLocation.getZ()), new Location(signLocation.getWorld(), signLocation.getX(), signLocation.getY()+2, signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY()+2, signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY()+2, signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY()+2, signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY()+2, signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY()-1, signLocation.getZ()), new Location(signLocation.getWorld(), signLocation.getX(), signLocation.getY()-1, signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY()-1, signLocation.getZ()), new Location(signLocation.getWorld(), signLocation.getX(), signLocation.getY()-1, signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY()-1, signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()+1, signLocation.getY()-1, signLocation.getZ()-1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY()-1, signLocation.getZ()+1), new Location(signLocation.getWorld(), signLocation.getX()-1, signLocation.getY()-1, signLocation.getZ()-1) };
        ArrayList<Block> blocks = new ArrayList<Block>();
        for (Location loc : locations) {
            if (loc.getBlock().getType() == Material.STAINED_GLASS) {
                blocks.add(loc.getBlock());
            }
        }
        signLocation.getBlock().setType(Material.AIR);
        for (Block b : blocks) {
            b.setType(Material.AIR);
        }
    }

}
