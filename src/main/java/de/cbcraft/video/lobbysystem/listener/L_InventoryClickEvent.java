package de.cbcraft.video.lobbysystem.listener;

import de.cbcraft.video.lobbysystem.Data;
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
            }
        }
    }
}
