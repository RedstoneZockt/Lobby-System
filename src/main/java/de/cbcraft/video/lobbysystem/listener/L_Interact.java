package de.cbcraft.video.lobbysystem.listener;

import de.cbcraft.video.lobbysystem.Data;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;


public class L_Interact implements Listener {

    @EventHandler
    public static void onInteract(PlayerInteractEvent e) {
        if(!Data.buildplayers.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}
