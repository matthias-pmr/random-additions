package eu.pommeray.randomadditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

/**
 * This class tests the method onItemConsumption
 * with the Poisonous Potato Consumption Random Teleport.
 */
class PoisonousPotatoConsumptionRandomTeleportTest {
  @Mock
  private ServerMock fakeServer;
  private PlayerMock fakePlayer;
  // Creates a poisonous Potato ItemStack
  ItemStack poisonousPotato = new ItemStack(Material.POISONOUS_POTATO);

  @BeforeEach
  public void setUp() {
    // Start the mock server
    fakeServer = MockBukkit.mock();
    // Load the RandomAdditions plugin
    MockBukkit.load(RandomAdditions.class);
    // Create a fake player
    fakePlayer = fakeServer.addPlayer();
    fakePlayer.setName("Lucaaaaaaaas");
  }

  @AfterEach
  public void tearDown() {
    // Stop the mock server
    MockBukkit.unmock();
  }

  @Test
  public void testPlayerRandomTeleportAfterEatingPoisonousPotato() {
    // Simulate the player eating a poisonous Potato
    PlayerItemConsumeEvent event = new PlayerItemConsumeEvent(fakePlayer,
            poisonousPotato, EquipmentSlot.HAND);
    // Get the original Location of the player
    Location originalLocation = fakePlayer.getLocation();
    // Make the plugin trigger the event
    fakeServer.getPluginManager().callEvent(event);
    // The maximum distance the player can be teleported
    // that equals the diagonal of a 1000x1000 square
    double maximumDistanceExpected = 1414.22;
    fakePlayer.assertTeleported(originalLocation, maximumDistanceExpected);
  }

  @Test
  public void testMessageReceivedByThePlayer() {
    // Simulate the PlayerAdvancementDoneEvent
    PlayerItemConsumeEvent event = new PlayerItemConsumeEvent(fakePlayer,
          poisonousPotato, EquipmentSlot.HAND);
    fakeServer.getPluginManager().callEvent(event);
    // Skip the first message that asserts the loading of the plugin
    fakePlayer.nextMessage();
    // Register the message of the Poisonous Potato Consumption
    String message = fakePlayer.nextMessage();
    assertEquals("§8§m-----------------------------------------\n"
          + "§cYou ate a poisonous potato and got teleported!"
          + "§8§m-----------------------------------------\n", message);
  }
}
