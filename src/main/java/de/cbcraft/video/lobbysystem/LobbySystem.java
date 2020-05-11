package de.cbcraft.video.lobbysystem;

import de.cbcraft.video.lobbysystem.commands.CMD_build;
import de.cbcraft.video.lobbysystem.commands.CMD_setloc;
import de.cbcraft.video.lobbysystem.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbySystem extends JavaPlugin {

    public static LobbySystem instance;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new L_Join(), this);
        Bukkit.getPluginManager().registerEvents(new L_Quit(), this);
        Bukkit.getPluginManager().registerEvents(new L_Break(), this);
        Bukkit.getPluginManager().registerEvents(new L_Build(), this);
        Bukkit.getPluginManager().registerEvents(new L_Damage(), this);
        Bukkit.getPluginManager().registerEvents(new L_Interact(), this);
        Bukkit.getPluginManager().registerEvents(new L_InventoryClickEvent(), this);
        Bukkit.getPluginCommand("build").setExecutor(new CMD_build());
        Bukkit.getPluginCommand("setloc").setExecutor(new CMD_setloc());
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
