package eu.pommeray.random_additions;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Random_additions extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.getPlayer().sendMessage("Hello " + event.getPlayer().getName() + ", this is a message proving that the plugin successfully loads!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
