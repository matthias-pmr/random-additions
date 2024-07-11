package eu.pommeray.randomadditions.events;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;


/**
 * This class makes a Player Teleport itself when eating a poisonous potato.
 */
public class PoisonousPotatoConsumptionRandomTeleport implements Listener {
  /**
   * The method is called when the Player finishes to eat something.
   *
   * @param event the event that is called when the player eats something
   */
  @EventHandler
  public void onItemConsumption(PlayerItemConsumeEvent event) {
    if (event.getItem().getType() == Material.POISONOUS_POTATO) {
      Player player = event.getPlayer();
      Random random = new Random();
      int x = random.nextInt(1000) - 1000;
      int z = random.nextInt(1000) - 1000;
      int y = player.getWorld().getHighestBlockYAt(x, z);
      Location randomLocation = new Location(player.getWorld(), x, y, z);
      player.sendMessage("§8§m----------------------------------------- \n"
              + "§cYou ate a poisonous potato and got teleported!"
              + "§8§m----------------------------------------- \n");
      player.teleport(randomLocation);
    }
  }
}
