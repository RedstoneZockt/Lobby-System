package de.cbcraft.video.lobbysystem.listener;

import de.cbcraft.video.lobbysystem.utils.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class L_Join implements Listener {

    @EventHandler
    public static void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(Config.getMessage("messages.join", e.getPlayer().getDisplayName()));
    }
}
