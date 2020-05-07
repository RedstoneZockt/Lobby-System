package de.cbcraft.video.lobbysystem.listener;

import de.cbcraft.video.lobbysystem.utils.Config;
import de.cbcraft.video.lobbysystem.utils.ItemBuilder;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class L_Join implements Listener {

    @EventHandler
    public static void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(Config.getMessage("messages.join", e.getPlayer().getDisplayName()));
        Player player = e.getPlayer();
        player.getInventory().clear();
        player.setGameMode(GameMode.ADVENTURE);
        ItemStack navigator = new ItemBuilder(Material.COMPASS, 1).setName("§aNavigator").toItemStack();
        player.getInventory().setItem(4, navigator);
    }
}
