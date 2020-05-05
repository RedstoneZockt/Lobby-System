package de.cbcraft.video.lobbysystem;

import de.cbcraft.video.lobbysystem.listener.L_Join;
import de.cbcraft.video.lobbysystem.listener.L_Quit;
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
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
