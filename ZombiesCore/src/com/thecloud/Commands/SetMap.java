package com.thecloud.Commands;

import com.thecloud.Structure.FileManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class SetMap implements CommandExecutor{

    FileManager settings = FileManager.getInstance();
    public static Permission setMap = new Permission("zombies.SetMap");

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can set the map!");
        }

        Player p = (Player) sender;

        if (p.hasPermission(setMap)) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED+"Correct usage: "+ChatColor.YELLOW+"/setmap "+ChatColor.RESET+"<map name>");
            } else if (args.length > 0) {
                StringBuilder x = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    x.append(args[i] + " ");
                }
                settings.getConfig().set("map", x.toString().trim());
                settings.saveConfig();
                p.sendMessage(ChatColor.GREEN+"Set this server's map to: "+ChatColor.WHITE+x.toString().trim()+ChatColor.GREEN+"!");
            }
        } else {
            p.sendMessage("Unknown command. Please type /help for help.");
        }

        return true;
    }
}
