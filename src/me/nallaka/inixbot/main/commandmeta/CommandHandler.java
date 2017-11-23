package me.nallaka.inixbot.main.commandmeta;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandHandler {
    private CommandRegistry commandRegistry = new CommandRegistry();

    private boolean isCommand(MessageReceivedEvent event, String[] commandArgs) {
        return event.getAuthor().getJDA().getSelfUser() != event.getAuthor() && commandRegistry.containsKey(commandArgs[0].toLowerCase()) && !commandArgs[0].equalsIgnoreCase("help");
    }

    private boolean isHelpCommand(MessageReceivedEvent event, String[] commandArgs) {
        return event.getAuthor().getJDA().getSelfUser() != event.getAuthor() && commandArgs[0].equalsIgnoreCase("help");
    }

    public void executeCommand(MessageReceivedEvent event, String[] commandArgs) {
        if (isCommand(event, commandArgs) || isHelpCommand(event, commandArgs) && commandArgs.length == 1) {
            commandRegistry.getCommand(commandArgs[0]).runCommand(event, commandArgs);
            commandRegistry.getCommand(commandArgs[0]).executed(event, commandArgs);
        } else if (isHelpCommand(event, commandArgs) && commandArgs.length >= 1) {
            commandRegistry.getCommand(commandArgs[1]).runHelpCommand(event, commandArgs);
            commandRegistry.getCommand(commandArgs[0]).executed(event, commandArgs);
        }
    }

}
