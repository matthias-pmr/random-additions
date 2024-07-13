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
    Random random = new Random();
    if (event.getItem().getType() == Material.POISONOUS_POTATO) {
      Player player = event.getPlayer();
      int negativeOrPositive = random.nextInt(2) == 0 ? -1 : 1;
      int x = random.nextInt(1000) * negativeOrPositive;
      int z = random.nextInt(1000) * negativeOrPositive;
      // Adding + 1 to the y coordinate to prevent the player from being stuck in the ground
      int y = player.getWorld().getHighestBlockYAt(x, z) + 1;
      Location randomLocation = new Location(player.getWorld(), x, y, z);
      player.sendMessage("§8§m-----------------------------------------\n"
              + "§cYou ate a poisonous potato and got teleported!\n"
              + "§8§m-----------------------------------------\n");
      player.teleport(randomLocation);
    }
  }
}
