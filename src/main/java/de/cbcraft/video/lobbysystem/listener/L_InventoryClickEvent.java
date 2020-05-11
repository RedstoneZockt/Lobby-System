package de.cbcraft.video.lobbysystem.listener;

import de.cbcraft.video.lobbysystem.Data;
import de.cbcraft.video.lobbysystem.LobbySystem;
import de.cbcraft.video.lobbysystem.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

import java.io.File;

public class L_InventoryClickEvent implements Listener {

    @EventHandler
    public static void onInventoryClick(InventoryClickEvent e) {
        if(e.getWhoClicked() instanceof Player) {
            Player player = (Player) e.getWhoClicked();
            if(!Data.buildplayers.contains(player)) {
                e.setCancelled(true);
                if(e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Config.getMessage("menu.inventory.item.1.name"))) {
                        String locname = Config.getMessage("menu.inventory.item.1.location");
                        File file = new File("plugins" + File.separator + LobbySystem.instance.getName() + File.separator + "location.yml");
                        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                        if(!cfg.isSet("location." + locname + ".x")) {
                            player.sendMessage(Config.getMessage("messages.navigator.teleport.not-found"));
                            return;
                        }
                        double x = cfg.getDouble("location." + locname + ".x");
                        double y = cfg.getDouble("location." + locname + ".y");
                        double z = cfg.getDouble("location." + locname + ".z");
                        float yaw = cfg.getInt("location." + locname + ".yaw");
                        float pitch = cfg.getInt("location." + locname + ".pitch");
                        World w = Bukkit.getWorld(cfg.getString("location." + locname + ".world"));
                        if(w != null) {
                            Location loc = new Location(w, x, y, z, yaw, pitch);
                            player.teleport(loc);
                        }else {
                            player.sendMessage(Config.getMessage("messages.navigator.teleport.not-found"));
                        }
                    }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Config.getMessage("menu.inventory.item.2.name"))) {
                        String locname = Config.getMessage("menu.inventory.item.2.location");
                        File file = new File("plugins" + File.separator + LobbySystem.instance.getName() + File.separator + "location.yml");
                        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                        if(!cfg.isSet("location." + locname + ".x")) {
                            player.sendMessage(Config.getMessage("messages.navigator.teleport.not-found"));
                            return;
                        }
                        double x = cfg.getDouble("location." + locname + ".x");
                        double y = cfg.getDouble("location." + locname + ".y");
                        double z = cfg.getDouble("location." + locname + ".z");
                        float yaw = cfg.getInt("location." + locname + ".yaw");
                        float pitch = cfg.getInt("location." + locname + ".pitch");
                        World w = Bukkit.getWorld(cfg.getString("location." + locname + ".world"));
                        if(w != null) {
                            Location loc = new Location(w, x, y, z, yaw, pitch);
                            player.teleport(loc);
                        }else {
                            player.sendMessage(Config.getMessage("messages.navigator.teleport.not-found"));
                        }
                    }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Config.getMessage("menu.inventory.item.3.name"))) {
                        String locname = Config.getMessage("menu.inventory.item.3.location");
                        File file = new File("plugins" + File.separator + LobbySystem.instance.getName() + File.separator + "location.yml");
                        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                        if(!cfg.isSet("location." + locname + ".x")) {
                            player.sendMessage(Config.getMessage("messages.navigator.teleport.not-found"));
                            return;
                        }
                        double x = cfg.getDouble("location." + locname + ".x");
                        double y = cfg.getDouble("location." + locname + ".y");
                        double z = cfg.getDouble("location." + locname + ".z");
                        float yaw = cfg.getInt("location." + locname + ".yaw");
                        float pitch = cfg.getInt("location." + locname + ".pitch");
                        World w = Bukkit.getWorld(cfg.getString("location." + locname + ".world"));
                        if(w != null) {
                            Location loc = new Location(w, x, y, z, yaw, pitch);
                            player.teleport(loc);
                        }else {
                            player.sendMessage(Config.getMessage("messages.navigator.teleport.not-found"));
                        }
                    }
                }
            }
        }
    }
}
