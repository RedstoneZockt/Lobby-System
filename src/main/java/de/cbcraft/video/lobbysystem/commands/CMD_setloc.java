package de.cbcraft.video.lobbysystem.commands;

import de.cbcraft.video.lobbysystem.LobbySystem;
import de.cbcraft.video.lobbysystem.utils.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;

public class CMD_setloc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("lobby.setloc")) {
            if(sender instanceof Player) {
                if(args.length == 1) {
                    Player player = (Player) sender;
                    File file = new File("plugins" + File.separator + LobbySystem.instance.getName() + File.separator + "location.yml");
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                    cfg.set("location." + args[0] + ".x", player.getLocation().getX());
                    cfg.set("location." + args[0] + ".y", player.getLocation().getY());
                    cfg.set("location." + args[0] + ".z", player.getLocation().getZ());
                    cfg.set("location." + args[0] + ".yaw", player.getLocation().getYaw());
                    cfg.set("location." + args[0] + ".pitch", player.getLocation().getPitch());
                    cfg.set("location." + args[0] + ".world", player.getLocation().getWorld().getName());
                    try {
                        cfg.save(file);
                        player.sendMessage(Config.getMessage("messages.setloc.success", args[0]));
                    } catch (IOException e) {
                        player.sendMessage(Config.getMessage("messages.setloc.error", e.getMessage()));
                    }
                }else {
                    sender.sendMessage(Config.getMessage("messages.setloc.syntax"));
                }
            }
        }
        return false;
    }
}
