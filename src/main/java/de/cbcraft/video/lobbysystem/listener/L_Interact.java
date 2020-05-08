package de.cbcraft.video.lobbysystem.listener;

import de.cbcraft.video.lobbysystem.Data;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;


public class L_Interact implements Listener {

    @EventHandler
    public static void onInteract(PlayerInteractEvent e) {
        if(!Data.buildplayers.contains(e.getPlayer())) {
            e.setCancelled(true);
            if(e.getHand() == EquipmentSlot.HAND) {
                if(e.getItem() != null && e.getItem().getType() != Material.AIR) {
                    if(e.getItem().hasItemMeta()) {
                        if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aNavigator")) {
                            e.getPlayer().openInventory(Data.getMenu());
                        }
                    }
                }
            }
        }
    }
}
