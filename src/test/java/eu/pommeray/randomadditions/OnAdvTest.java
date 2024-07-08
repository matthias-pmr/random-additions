package eu.pommeray.randomadditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class OnAdvTest {
  @Mock
  private ServerMock fakeServer;
  private RandomAdditions plugin;
  PlayerMock fakePlayer;
  Advancement mockAdvancement = Mockito.mock(Advancement.class);

  @BeforeEach
  public void setUp() {
    // Start the mock server
    fakeServer = MockBukkit.mock();
    // Load the RandomAdditions plugin
    plugin = MockBukkit.load(RandomAdditions.class);
    // Create a fake player
    fakePlayer = fakeServer.addPlayer();
    fakePlayer.getInventory().clear(); // Make sure that the inventory doesn't contain already a diamond sword
    fakePlayer.setName("Clarinette57");
    Mockito.when(mockAdvancement.getKey())
            .thenReturn(new NamespacedKey("minecraft", "adventure/kill_a_mob"));
  }

  @AfterEach
  public void tearDown() {
    // Stop the mock server
    MockBukkit.unmock();
  }

  @Test
  public void testIfAnItemIsGivenForKillingTheFirstMob() {
    //Simulate the PlayerAdvancementDoneEvent
    PlayerAdvancementDoneEvent event = new PlayerAdvancementDoneEvent(fakePlayer, mockAdvancement);
    fakeServer.getPluginManager().callEvent(event);
    assertTrue(fakePlayer.getInventory().contains(Material.DIAMOND_SWORD));
  }
}