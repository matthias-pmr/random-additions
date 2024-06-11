package eu.pommeray.random_additions;
import eu.pommeray.random_additions.commands.Calculator;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
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

    @EventHandler
    public void onAch(PlayerAdvancementDoneEvent event){
        Player player = event.getPlayer();
        Advancement advancement = event.getAdvancement();
        String name = advancement.getKey().getKey();
        if(name.equalsIgnoreCase("minecraft:adventure/kill_a_mob")) {
            player.playNote(player.getLocation(), Instrument.PIANO, Note.natural(1, Note.Tone.A));
            player.playNote(player.getLocation(), Instrument.BASS_GUITAR, Note.natural(1, Note.Tone.A));
            player.sendMessage("§8§m-----------------------------------------");
            player.sendMessage("§a§lCONGRATS!");
            player.sendMessage("§fYou killed your first §bMob §f!");
            player.sendMessage("§8§m-----------------------------------------");
            PlayerInventory inventory = player.getInventory();
            ItemStack IS = new ItemStack(Material.DIAMOND_SWORD);
            inventory.addItem();
            player.sendMessage("§8§m-----------------------------------------");
            player.sendMessage("§a§lYou were given a Diamond Sword, check your Inventory!");
            player.sendMessage("§8§m-----------------------------------------");
        }
    }
}
