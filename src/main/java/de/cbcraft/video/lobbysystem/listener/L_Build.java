package de.cbcraft.video.lobbysystem.listener;

import de.cbcraft.video.lobbysystem.Data;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class L_Build implements Listener {

    @EventHandler
    public static void onBuild(BlockPlaceEvent e) {
        if(!Data.buildplayers.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}
