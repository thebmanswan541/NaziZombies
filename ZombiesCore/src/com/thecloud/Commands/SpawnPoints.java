package com.thecloud.Commands;

import com.thecloud.Structure.FileManager;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class SpawnPoints implements CommandExecutor{

    public static Permission spawnPoints = new Permission("zombies.SpawnPoints");
    FileManager settings = FileManager.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("spawnpoints")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players can set spawn points!");
            }
            Player p = (Player) sender;

            if (p.hasPermission(spawnPoints)) {
                if (args.length < 2) {
                    p.sendMessage(ChatColor.RED+"Correct usage: "+ChatColor.YELLOW+"/spawnpoints "+ChatColor.WHITE+"<add | remove> <index>");
                    return true;
                } else {
                    String name = args[1];
                    if (args[0].equalsIgnoreCase("add")) {
                        String world = p.getWorld().getName();
                        double x = p.getLocation().getX();
                        double y = p.getLocation().getY();
                        double z = p.getLocation().getZ();
                        settings.getSpawnPoints().set("spawnpoints."+name+".world", world);
                        settings.getSpawnPoints().set("spawnpoints."+name+".x", x);
                        settings.getSpawnPoints().set("spawnpoints."+name+".y", y);
                        settings.getSpawnPoints().set("spawnpoints."+name+".z", z);
                        settings.saveSpawnPoints();
                        p.sendMessage(ChatColor.GREEN+"Added spawn point: "+ChatColor.RESET+name+ChatColor.GREEN+"!");
                    } else if (args[0].equalsIgnoreCase("remove")) {
                        if (settings.getSpawnPoints().get("spawnpoints."+name) == null) {
                            p.sendMessage(ChatColor.RED+"Could not find the spawn point "+name+".");
                        } else {
                            settings.getSpawnPoints().set("spawnpoints."+name, null);
                            settings.saveSpawnPoints();
                            p.sendMessage(ChatColor.GREEN+"Removed spawn point: "+ChatColor.RESET+name+ChatColor.GREEN+"!");
                        }
                    }
                }
            } else {
                p.sendMessage("Unknown command. Please type /help for help.");
            }
        }
        return true;
    }
}
