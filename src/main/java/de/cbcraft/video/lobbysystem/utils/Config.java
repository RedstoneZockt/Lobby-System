package de.cbcraft.video.lobbysystem.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;

public class Config {


    public static String getMessage(String path, String... replacements) {
        File file = new File("plugins" + File.separator + "LobbySystem" + File.separator + "config.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if(cfg.isSet(path)) {
            String message = cfg.getString(path);
            int replace = 0;
            for(String all : replacements) {
                message = message.replaceAll("\\[" + replace + "\\]", all);
                replace++;
            }
            message = message.replaceAll("%prefix%", getPrefix());
            message = ChatColor.translateAlternateColorCodes('&', message);
            return message;
        }else {
            return "§cNachricht wurde nicht gefunden!";
        }
    }

    public static String getPrefix() {
        File file = new File("plugins" + File.separator + "LobbySystem" + File.separator + "config.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if(cfg.isSet("prefix")) {
            String message = cfg.getString("prefix");
            message = ChatColor.translateAlternateColorCodes('&', message);
            return message;
        }else {
            return "§7";
        }
    }
}
