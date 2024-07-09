package eu.pommeray.randomadditions.events;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerTeleportEvent;


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
      int y = 100;
      int z = random.nextInt(1000) - 1000;
      Location randomLocation = new Location(player.getWorld(), x, y, z);
      player.teleport(randomLocation);
      player.sendMessage("§8§m----------------------------------------- \n"
              + "§cYou ate a poisonous potato and got teleported!"
              + "§8§m----------------------------------------- \n");
    }
  }
  /*
  public void onTeleport(PlayerTeleportEvent event) {
    Player player = event.getPlayer();
    player.sendMessage("§8§m----------------------------------------- \n"
              + "§cYou got teleported and that created a Storm!"
              + "§8§m----------------------------------------- \n");
  */
}
