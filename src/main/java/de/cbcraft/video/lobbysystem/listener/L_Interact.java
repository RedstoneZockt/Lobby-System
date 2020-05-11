package de.cbcraft.video.lobbysystem.listener;

import de.cbcraft.video.lobbysystem.Data;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;


public class L_Interact implements Listener {

    /*@EventHandler
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
    }*/

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            if(Data.buildplayers.contains(event.getPlayer())) return;

            ItemStack item = event.getPlayer().getItemInHand().clone();

            if(item != null && item.getType() != Material.AIR && item.hasItemMeta())
            {
                if(item.getItemMeta().getDisplayName().equalsIgnoreCase("§aNavigator"))
                {
                    event.getPlayer().openInventory(Data.getMenu());
                }
            }
        }
    }
}
