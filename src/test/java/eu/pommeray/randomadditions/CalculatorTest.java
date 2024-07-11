package eu.pommeray.randomadditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

/**
 * This class tests the calculator.
 */
public class CalculatorTest {
  @Mock
  private ServerMock fakeServer;
  PlayerMock fakePlayer;

  /**
   * This method is called before each test.
   */
  @BeforeEach
  public void setUp() {
    // Start the mock server
    fakeServer = MockBukkit.mock();
    // Load the RandomAdditions plugin
    MockBukkit.load(RandomAdditions.class);
    // Create a fake player
    fakePlayer = fakeServer.addPlayer();
    fakePlayer.setName("xx_fakePlayer_xx");
  }

  /**
   * This method is called after each test.
   */
  @AfterEach
  public void tearDown() {
    // Stop the mock server
    MockBukkit.unmock();
  }

  @Test
  public void calculatorWrongArgumentsTest() {
    // Player issues the command with not enough arguments
    fakePlayer.performCommand("calculator 5");
    fakePlayer.nextMessage(); // skip the first message sent by the console
    String message = fakePlayer.nextMessage();
    assertEquals("------------------------------------------\n"
          + "Description: Allows calculations of simple expressions \n"
          + "Operators available: +, *, / \n"
          + "------------------------------------------\n", message);
  }

  @Test
  public void calculatorAdditionOperation() {
    int firstNumber = 5;
    int secondNumber = 7;
    String chosenOperation = "+";
    String expectedResult = "12";
    // Player issues an addition that should return the right result
    fakePlayer.performCommand("calculator 5 + 7");
    // Skip the first message sent by the console
    fakePlayer.nextMessage();
    String message = fakePlayer.nextMessage();
    assertEquals("The result of " + firstNumber
         + " " + chosenOperation + " " + secondNumber + " is: " + expectedResult, message);
  }

  @Test
  public void calculatorMultiplicationOperation() {
    int firstNumber = 3;
    int secondNumber = -3;
    String chosenOperation = "*";
    String expectedResult = "-9";
    // Player issues an addition that should return the right result
    fakePlayer.performCommand("calculator 3 * -3");
    // Skip the first message sent by the console
    fakePlayer.nextMessage();
    String message = fakePlayer.nextMessage();
    assertEquals("The result of " + firstNumber
          + " " + chosenOperation + " " + secondNumber + " is: " + expectedResult, message);
  }

  @Test
  public void calculatorDivisionOperation() {
    int firstNumber = 15;
    int secondNumber = 5;
    String chosenOperation = "/";
    String expectedResult = "3";
    // Player issues an addition that should return the right result
    fakePlayer.performCommand("calculator 15 / 5");
    // Skip the first message sent by the console
    fakePlayer.nextMessage();
    String message = fakePlayer.nextMessage();
    assertEquals("The result of " + firstNumber
        + " " + chosenOperation + " " + secondNumber + " is: " + expectedResult, message);
  }
}
