package eu.pommeray.randomadditions.commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


/**
 * The class we will use to allow players to make simple calculations.
 */
public class Calculator implements CommandExecutor {
  private final Logger logger;

  public Calculator(Logger logger) {
    this.logger = logger;
  }

  /**
  * This method is called, when somebody uses our command.
  *
  * @param sender  the sender of the command
  * @param command the command that was executed
  * @param label   the label of the command
  * @param args    the arguments of the command (in this case, the numbers and the operation)
  * @return if the command was successfully executed
  */
  @Override
  public boolean onCommand(CommandSender sender,
                           Command command,
                           String label,
                           String[] args) {
    boolean worked = true;
    if (args.length != 3 || args[1].equals("help")) {
      sender.sendMessage(
          "------------------------------------------\n"
              + "Description: Allows calculations of simple expressions \n"
              + "Operators available: +, *, / \n"
              + "------------------------------------------\n");
      return false;
    }
    int firstNumber = 0;
    int secondNumber = 0;
    String operation = args[1];
    try {
      firstNumber = Integer.parseInt(args[0]);
      secondNumber = Integer.parseInt(args[2]);
    } catch (NumberFormatException e) {
      logger.log(Level.SEVERE,
              "An error occurred while parsing numbers or executing the operation", e);
      worked = false;
    }
    switch (operation) {
      case "+": {
        int result = firstNumber + secondNumber;
        sender.sendMessage("The result of " + firstNumber
                + " + " + secondNumber + " is: " + result);
        break;
      }
      case "*": {
        int result = firstNumber * secondNumber;
        sender.sendMessage("The result of " + firstNumber
                  + " * " + secondNumber + " is: " + result);
        break;
      }
      case "/": {
        if (secondNumber != 0) {
          double result = (double) firstNumber / secondNumber;
          sender.sendMessage("The result of " + firstNumber
                      + " / " + secondNumber + " is: " + result);
        } else {
          sender.sendMessage("The result of " + firstNumber
                      + " / " + secondNumber + " is impossible to calculate");
        }
        break;
      }
      default: {
        worked = false;
        break;
      }
    }
    return worked;
  }
}
