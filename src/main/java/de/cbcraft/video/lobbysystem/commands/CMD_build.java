package de.cbcraft.video.lobbysystem.commands;

import de.cbcraft.video.lobbysystem.Data;
import de.cbcraft.video.lobbysystem.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_build implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("lobby.build")) {
            if(args.length == 0) {
                if(sender instanceof Player) {
                    Player player = (Player) sender;
                    if(Data.buildplayers.contains(player)) {
                        Data.buildplayers.remove(player);
                        player.sendMessage(Config.getMessage("messages.build.self.disable"));
                    }else {
                        Data.buildplayers.add(player);
                        player.sendMessage(Config.getMessage("messages.build.self.enable"));
                    }
                }else {
                    sender.sendMessage(Config.getMessage("messages.build.syntax"));
                }
            }else if(args.length == 1) {
                Player player = Bukkit.getPlayer(args[0]);
                if(player != null) {
                    if(Data.buildplayers.contains(player)) {
                        Data.buildplayers.remove(player);
                        player.sendMessage(Config.getMessage("messages.build.self.disable"));
                        sender.sendMessage(Config.getMessage("messages.build.other.disable", player.getDisplayName()));
                    }else {
                        Data.buildplayers.add(player);
                        player.sendMessage(Config.getMessage("messages.build.self.enable"));
                        sender.sendMessage(Config.getMessage("messages.build.other.enable", player.getDisplayName()));
                    }
                }else {
                    sender.sendMessage(Config.getMessage("messages.build.not-online"));
                }
            }else {
                sender.sendMessage(Config.getMessage("messages.build.syntax"));
            }
        }else {
            sender.sendMessage(Config.getMessage("messages.noperm"));
        }
        return false;
    }
}
