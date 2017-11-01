package me.nallaka.inixbot.main;

import me.nallaka.inixbot.maps.CommandMaps;
import me.nallaka.inixbot.maps.HelpCommandMap;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

class CommandHandler {
    private CommandMaps commandMap = new CommandMaps();
    private HelpCommandMap helpCommandMap = new HelpCommandMap();

    //Checks if command exists in the map
    boolean isCommand(MessageReceivedEvent event, String[] commandArgs) {
        return event.getAuthor().getJDA().getSelfUser() != event.getAuthor() && commandMap.containsKey(commandArgs[0].toLowerCase()) && !commandArgs[0].equalsIgnoreCase("help");
    }

    //Checks if help command args are in help command map
    boolean isHelpCommand(MessageReceivedEvent event, String[] commandArgs) {
        return event.getAuthor().getJDA().getSelfUser() != event.getAuthor() && commandArgs[0].equalsIgnoreCase("help");
    }

    //Executres the appropriate command after checking command type
    void executeCommand(MessageReceivedEvent event, String[] commandArgs) {
        if (isCommand(event, commandArgs) || isHelpCommand(event, commandArgs) && commandArgs.length == 1) {
            commandMap.getCommand(commandArgs[0]).called(event, commandArgs);
            commandMap.getCommand(commandArgs[0]).runCommand(event, commandArgs);
            commandMap.getCommand(commandArgs[0]).executed(event, commandArgs);
        } else if (isHelpCommand(event, commandArgs) && commandArgs.length >= 1) {
           helpCommandMap.getHelpCommand(commandArgs[1]).called(event, commandArgs);
           helpCommandMap.getHelpCommand(commandArgs[1]).runCommand(event, commandArgs);
           helpCommandMap.getHelpCommand(commandArgs[1]).executed(event, commandArgs);
        }
    }

}
