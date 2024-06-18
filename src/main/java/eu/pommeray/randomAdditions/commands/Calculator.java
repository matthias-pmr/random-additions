package eu.pommeray.randomAdditions.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class Calculator implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        boolean worked;
        int firstNumber = 0;
        int secondNumber = 0;
        String operation = args[1];
        try {
            firstNumber = Integer.parseInt(args[0]);
            secondNumber = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (operation) {
            case "+": {
                int result = firstNumber + secondNumber;
                sender.sendMessage("The result of " + firstNumber + " + " + secondNumber + " is: " + result);
                worked = true;
                break;
            }
            case "*": {
                int result = firstNumber * secondNumber;
                sender.sendMessage("The result of " + firstNumber + " * " + secondNumber + " is: " + result);
                worked = true;
                break;
            }
            case "/": {
                if (secondNumber != 0){
                    int result = firstNumber / secondNumber;
                    sender.sendMessage("The result of " + firstNumber + " / " + secondNumber + " is: " + result);
                } else {
                    sender.sendMessage("The result of " + firstNumber + " / " + secondNumber + " is impossible to calculate");
                }
                worked = true;
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
