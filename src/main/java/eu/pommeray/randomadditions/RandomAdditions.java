package eu.pommeray.randomadditions;

import eu.pommeray.randomadditions.commands.Calculator;
import eu.pommeray.randomadditions.events.FirstMonsterKilledReward;
import eu.pommeray.randomadditions.events.PoisonousPotatoConsumptionRandomTeleport;
import java.util.Objects;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
* The basic class: contains all the methods that are called during the game.
*/
public class RandomAdditions extends JavaPlugin implements Listener {

  /**
  * This method is called when the plugin is enabled.
  */
  @Override
  public void onEnable() {
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(this, this);
    pm.registerEvents(new FirstMonsterKilledReward(), this);
    pm.registerEvents(new PoisonousPotatoConsumptionRandomTeleport(), this);
    try {
      Objects.requireNonNull(this.getCommand("calculator"))
              .setExecutor(new Calculator(this.getLogger()));
    } catch (NullPointerException e) {
      getLogger().log(java.util.logging.Level.SEVERE,
              "Could not register the command calculator", e);
    }
  }

  /**
  * This method is called when a player joins the server.
  *
  * @param event the event that is triggered when a player joins the server
  */
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    event.getPlayer().sendMessage("Hello " + event.getPlayer().getName()
                + ", this is a message proving that the plugin successfully loads!");
  }

  /**
   * This method is only used if the plugin should be disabled.
   */
  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }




}
