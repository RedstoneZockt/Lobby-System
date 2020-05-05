package de.cbcraft.video.lobbysystem.listener;

import de.cbcraft.video.lobbysystem.utils.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class L_Quit implements Listener {

    @EventHandler
    public static void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(Config.getMessage("message.quit", e.getPlayer().getDisplayName()));
    }
}
