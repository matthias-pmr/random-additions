package eu.pommeray.randomadditions.events;

import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

/**
 * This class awards a player who completes the monster Hunter Advancement.
 */
public class FirstMonsterKilledReward implements Listener {
  /**
   * This method is called when a player completes an advancement.
   *
   * @param event the event that is triggered when a player completes an advancement
   */
  @EventHandler
  public void onAdv(PlayerAdvancementDoneEvent event) {
    Player player = event.getPlayer();
    Advancement advancement = event.getAdvancement();
    String name = advancement.getKey().getKey();
    if (name.equalsIgnoreCase("adventure/kill_a_mob")) {
      player.playNote(player.getLocation(), Instrument.PIANO, Note.natural(1, Note.Tone.A));
      player.playNote(player.getLocation(), Instrument.BASS_GUITAR, Note.natural(1, Note.Tone.A));
      player.sendMessage("§8§m----------------------------------------- \n"
              + "§a§lCONGRATS! \n "
              + "§fYou killed your first §bMob §f! \n "
              + "§8§m-----------------------------------------");
      PlayerInventory inventory = player.getInventory();
      inventory.addItem(new ItemStack(Material.DIAMOND_SWORD));
      player.sendMessage("§8§m-----------------------------------------");
      player.sendMessage("§a§lYou were given a Diamond Sword, check your Inventory!");
      player.sendMessage("§8§m-----------------------------------------");
    }
  }
}
