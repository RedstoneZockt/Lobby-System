package de.cbcraft.video.lobbysystem;

import de.cbcraft.video.lobbysystem.utils.Config;
import de.cbcraft.video.lobbysystem.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class Data {

    public static ArrayList<Player> buildplayers = new ArrayList<>();

    public static Inventory getMenu() {
        Inventory inventory = Bukkit.createInventory(null, 9, Config.getMessage("menu.inventory.name"));
        inventory.setItem(0, new ItemBuilder(Material.valueOf(Config.getMessage("menu.inventory.item.1.material")), 1).setName(Config.getMessage("menu.inventory.item.1.name")).toItemStack());
        inventory.setItem(4, new ItemBuilder(Material.valueOf(Config.getMessage("menu.inventory.item.2.material")), 1).setName(Config.getMessage("menu.inventory.item.2.name")).toItemStack());
        inventory.setItem(8, new ItemBuilder(Material.valueOf(Config.getMessage("menu.inventory.item.3.material")), 1).setName(Config.getMessage("menu.inventory.item.3.name")).toItemStack());
        return inventory;
    }
}
