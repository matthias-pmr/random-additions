package eu.pommeray.randomadditions;

import eu.pommeray.randomadditions.commands.Calculator;
import java.util.Objects;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
* The basic class: contains all the methods that are called during the game.
*/
public final class RandomAdditions extends JavaPlugin implements Listener {

  /**
  * This method is called when the plugin is enabled.
  */
  @Override
  public void onEnable() {
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(this, this);
    try {
      Objects.requireNonNull(this.getCommand("calculator")).setExecutor(new Calculator());
    } catch (NullPointerException e) {
      e.printStackTrace();
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

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }

  /**
  * This method is called when a player completes an advancement.
  *
  * @param event the event that is triggered when a player completes an advancement
  */
  @EventHandler
  public void onAdv(PlayerAdvancementDoneEvent event) {
    System.out.println("OnAdvancementDoneEvent triggered!");
    Player player = event.getPlayer();
    Advancement advancement = event.getAdvancement();
    String name = advancement.getKey().getKey();
    getLogger().info("name of the advancement: " + name);
    if (name.equalsIgnoreCase("adventure/kill_a_mob")) {
      player.playNote(player.getLocation(), Instrument.PIANO, Note.natural(1, Note.Tone.A));
      player.playNote(player.getLocation(), Instrument.BASS_GUITAR, Note.natural(1, Note.Tone.A));
      player.sendMessage("§8§m----------------------------------------- \n"
              + "§a§lCONGRATS! \n "
              + "§fYou killed your first §bMob §f! \n "
              + "§8§m-----------------------------------------");
      PlayerInventory inventory = player.getInventory();
      ItemStack itemStack = new ItemStack(Material.DIAMOND_SWORD);
      inventory.addItem(itemStack);
      player.sendMessage("§8§m-----------------------------------------");
      player.sendMessage("§a§lYou were given a Diamond Sword, check your Inventory!");
      player.sendMessage("§8§m-----------------------------------------");
    }
  }



  /*
  @EventHandler
  public void onItemConsumption(PlayerItemConsumeEvent event) {
    (event.getItem().getType() == Material.POISONOUS_POTATO) {
      Player player = event.getPlayer();
      poisonedPotatoEaters.add(player.getUniqueId());
      Random random = new Random();
      int x = random.nextInt(1000);
      int y = 100;
      int z = random.nextInt(1000);
      Location randomLocation = new Location(player.getWorld(), x, y, z);
      player.teleport(randomLocation);
      player.sendMessage("§8§m----------------------------------------- \n"
              + "§cYou ate a poisonous potato and got teleported!"
              + "§8§m----------------------------------------- \n");
     }
  }

  public void onTeleport(PlayerTeleportEvent event) {
    Player player = event.getPlayer();

    player.sendMessage("§8§m----------------------------------------- \n"
              + "§cYou got teleported and that created a Storm!"
              + "§8§m----------------------------------------- \n");
  */
}
