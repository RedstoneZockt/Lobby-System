package de.cbcraft.video.lobbysystem.listener;

import de.cbcraft.video.lobbysystem.Data;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class L_Break implements Listener {

    @EventHandler
    public static void onBreak(BlockBreakEvent e) {
        if(!Data.buildplayers.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}
