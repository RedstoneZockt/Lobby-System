package de.cbcraft.video.lobbysystem.listener;

import de.cbcraft.video.lobbysystem.Data;
import de.cbcraft.video.lobbysystem.utils.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class L_InventoryClickEvent implements Listener {

    @EventHandler
    public static void onInventoryClick(InventoryClickEvent e) {
        if(e.getWhoClicked() instanceof Player) {
            Player player = (Player) e.getWhoClicked();
            if(!Data.buildplayers.contains(player)) {
                e.setCancelled(true);
                if(e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Config.getMessage("menu.inventory.item.1.name"))) {
                        player.sendMessage("1");
                    }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Config.getMessage("menu.inventory.item.2.name"))) {
                        player.sendMessage("2");
                    }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Config.getMessage("menu.inventory.item.3.name"))) {
                        player.sendMessage("3");
                    }
                }
            }
        }
    }
}
