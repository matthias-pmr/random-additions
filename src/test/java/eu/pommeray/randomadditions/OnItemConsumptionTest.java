package eu.pommeray.randomadditions;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import eu.pommeray.randomadditions.events.PoisonousPotatoConsumptionRandomTeleport;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PoisonousPotatoConsumptionRandomTeleportTest {
    @Mock
    private ServerMock fakeServer;
    private PlayerMock fakePlayer;

    @BeforeEach
    public void setUp() {
        // Start the mock server
        fakeServer = MockBukkit.mock();
        // Load the RandomAdditions plugin
        MockBukkit.load(RandomAdditions.class);
        // Register the event listener
        fakeServer.getPluginManager().registerEvents(new PoisonousPotatoConsumptionRandomTeleport(), MockBukkit.load(RandomAdditions.class));
        // Create a fake player
        fakePlayer = fakeServer.addPlayer();

    }

    @AfterEach
    public void tearDown() {
        // Stop the mock server
        MockBukkit.unmock();
    }

    @Test
    public void testPlayerRandomTeleportAfterEatingPoisonousPotato() {
        // Creates a poisonous Potato ItemStack
        ItemStack poisonousPotato = new ItemStack(Material.POISONOUS_POTATO);

        // Simulate the player eating a poisonous Potato
        PlayerItemConsumeEvent event = new PlayerItemConsumeEvent(fakePlayer, poisonousPotato);

        // get the original Location of the player
        Location originalLocation = fakePlayer.getLocation();

        fakeServer.getPluginManager().callEvent(event);

        // Check that the player has been teleported
        Location newLocation = fakePlayer.getLocation();
        assertNotEquals(originalLocation, newLocation, "Player should be teleported to a different location that his original Location.");

    }
}
