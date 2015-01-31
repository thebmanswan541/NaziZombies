package com.thecloud.Commands;

import com.thecloud.Structure.FileManager;
import com.thecloud.Structure.Utilities;
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
            settings.getSpawns().set("spawn", world+":"+x+":"+y+":"+z);
            settings.saveSpawns();
            p.sendMessage(Utilities.tag()+ChatColor.GREEN+"Successfully set the spawn!");
        }
        return true;
    }
}
