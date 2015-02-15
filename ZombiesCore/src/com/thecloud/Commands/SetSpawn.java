package com.thecloud.Commands;

import com.thecloud.Structure.FileManager;
import com.thecloud.Structure.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.permissions.Permission;

public class SetSpawn implements CommandExecutor{

    public static Permission setSpawn = new Permission("zombies.SetSpawn");

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        FileManager settings = FileManager.getInstance();

        if (label.equalsIgnoreCase("setspawn")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
            }

            Player p = (Player) sender;

            if (p.hasPermission(setSpawn)) {
                String world = p.getWorld().getName();
                double x = p.getLocation().getX();
                double y = p.getLocation().getY();
                double z = p.getLocation().getZ();
                settings.getSpawns().set("spawn.world", world);
                settings.getSpawns().set("spawn.x", x);
                settings.getSpawns().set("spawn.y", y);
                settings.getSpawns().set("spawn.z", z);
                settings.getSpawns().set("spawn.pitch", p.getLocation().getPitch());
                settings.getSpawns().set("spawn.yaw", p.getLocation().getYaw());
                settings.saveSpawns();
                p.sendMessage(Utilities.tag() + ChatColor.GREEN + "Successfully set the spawn!");
            } else {
                p.sendMessage(ChatColor.WHITE+"Unknown command. Please type /help for help.");
            }
        }

        return true;
    }
}
