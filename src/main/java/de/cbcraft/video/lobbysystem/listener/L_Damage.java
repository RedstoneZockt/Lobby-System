package de.cbcraft.video.lobbysystem.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class L_Damage implements Listener {

    @EventHandler
    public static void onDamage(EntityDamageEvent e) {
        e.setCancelled(true);
    }
}
