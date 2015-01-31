package com.thecloud.Commands;

import com.thecloud.Structure.FileManager;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        FileManager settings = FileManager.getInstance();

        if (label.equalsIgnoreCase("setspawn")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED+"Only players can execute this command!");
            }

            Player p = (Player) sender;

            String world = p.getWorld().getName();
            double x = p.getLocation().getX();
            double y = p.getLocation().getY();
            double z = p.getLocation().getZ();
            String s = settings.getSpawns().getString("spawn");
            settings.getSpawns().set(s, world+":"+x+":"+y+":"+z);
            settings.saveSpawns();
        }
        return true;
    }
}
