package eu.pommeray.randomadditions;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class RandomAdditionsTest {
  @Test
  void testRandomAdditions() {
    assertTrue(true);
  }

  @Mock
  Server server = Mockito.mock(Server.class);
  private Player fakePlayer;
  private final Advancement fakeAdvancement = Mockito.mock(Advancement.class);
  private PlayerAdvancementDoneEvent event = new PlayerAdvancementDoneEvent(fakePlayer, fakeAdvancement);

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    NamespacedKey fakeKey = new NamespacedKey("minecraft", "kill_a_mob");
    when(fakeAdvancement.getKey()).thenReturn(fakeKey);
  }

  @Test
  public void testIfAnItemIsGivenForKillingTheFirstMob() {
    RandomAdditions randomAdditions = new RandomAdditions();
    randomAdditions.onAdv(event);
    assertTrue(fakePlayer.getInventory().contains(Material.DIAMOND));
  }
}