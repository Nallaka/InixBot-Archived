package me.nallaka.inixbot.main;

import me.nallaka.inixbot.registry.CommandRegistry;
import me.nallaka.inixbot.registry.HelpCommandRegistry;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

class CommandHandler {
    private CommandRegistry commandRegistry = new CommandRegistry();
    private HelpCommandRegistry helpCommandRegistry = new HelpCommandRegistry();

    boolean isCommand(MessageReceivedEvent event, String[] commandArgs) {
        return event.getAuthor().getJDA().getSelfUser() != event.getAuthor() && commandRegistry.containsKey(commandArgs[0].toLowerCase()) && !commandArgs[0].equalsIgnoreCase("helpcommands");
    }

    boolean isHelpCommand(MessageReceivedEvent event, String[] commandArgs) {
        return event.getAuthor().getJDA().getSelfUser() != event.getAuthor() && commandArgs[0].equalsIgnoreCase("helpcommands");
    }

    void executeCommand(MessageReceivedEvent event, String[] commandArgs) {
        if (isCommand(event, commandArgs) || isHelpCommand(event, commandArgs) && commandArgs.length == 1) {
            commandRegistry.getCommand(commandArgs[0]).called(event, commandArgs);
            commandRegistry.getCommand(commandArgs[0]).runCommand(event, commandArgs);
            commandRegistry.getCommand(commandArgs[0]).executed(event, commandArgs);
        } else if (isHelpCommand(event, commandArgs) && commandArgs.length >= 1) {
           helpCommandRegistry.getHelpCommand(commandArgs[1]).called(event, commandArgs);
           helpCommandRegistry.getHelpCommand(commandArgs[1]).runCommand(event, commandArgs);
           helpCommandRegistry.getHelpCommand(commandArgs[1]).executed(event, commandArgs);
        }
    }

}
