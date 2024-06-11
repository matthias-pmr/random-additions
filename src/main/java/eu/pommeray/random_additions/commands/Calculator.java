package eu.pommeray.random_additions.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Calculator implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        boolean worked = true;
        if (args.length == 0 || args.length > 3) {
            worked = false;
        }
        int firstNumber = 0;
        int secondNumber = 0;
        String operation = args[1];
        try {
            firstNumber = Integer.parseInt(args[0]);
            secondNumber = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e) {
            worked = false;
        }
        switch(operation) {
            case "+" : {
                sender.sendMessage("The result of " + firstNumber + " + " + secondNumber + " is: " + firstNumber+secondNumber);
            }
            case "*" : {
                sender.sendMessage("The result of " + firstNumber + " * " + secondNumber + " is: " + firstNumber*secondNumber);
            }
            case "/" : {
                sender.sendMessage("The result of " + firstNumber + " / " + secondNumber + " is: " + firstNumber/secondNumber);

            }
            default : {
                worked = false;
            }
        }
        return worked;

    }

}
