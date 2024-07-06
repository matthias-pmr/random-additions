package eu.pommeray.randomadditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
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
  NamespacedKey key = new NamespacedKey("minecraft", "adventure/kill_a_mob");

  @BeforeEach
  public void setUp() {
    // Start the mock server
    fakeServer = MockBukkit.mock();
    fakePlayer = fakeServer.addPlayer();
    fakePlayer.getInventory().clear();
  }

  @AfterEach
  public void tearDown() {
    // Stop the mock server
    MockBukkit.unmock();
  }


  @Test
  public void testIfAnItemIsGivenForKillingTheFirstMob() {
    fakePlayer.setName("Clarinette57");
    //System.out.println(fakeServer.getAdvancement(key));
    fakeServer.dispatchCommand(Bukkit.getConsoleSender(),
            "advancement revoke " + fakePlayer.getName() + " everything");
    fakeServer.dispatchCommand(
        Bukkit.getConsoleSender(),
        "advancement grant " + fakePlayer.getName() + " only adventure/kill_a_mob");
    assertTrue(fakePlayer.getInventory().contains(Material.DIAMOND));
  }
}