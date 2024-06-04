package eu.pommeray.random_additions;
import eu.pommeray.random_additions.commands.Calculator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomAdditions extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this,this);
        this.getCommand("calculator").setExecutor(new Calculator());
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
