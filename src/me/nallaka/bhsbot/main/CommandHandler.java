package me.nallaka.bhsbot.main;

import me.nallaka.bhsbot.maps.CommandMaps;
import me.nallaka.bhsbot.maps.HelpCommandMap;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import sun.misc.resources.Messages_de;

class CommandHandler {
    private CommandMaps commandMap = new CommandMaps();
    private HelpCommandMap helpCommandMap = new HelpCommandMap();

    boolean isCommand(MessageReceivedEvent event, String[] commandArgs) {
        return event.getAuthor().getJDA().getSelfUser() != event.getAuthor() && commandMap.containsKey(commandArgs[0].toLowerCase()) && !commandArgs[0].equalsIgnoreCase("help");
    }

    boolean isHelpCommand(MessageReceivedEvent event, String[] commandArgs) {
        return event.getAuthor().getJDA().getSelfUser() != event.getAuthor() && helpCommandMap.containsHelpKey(commandArgs[1].toLowerCase()) && commandArgs[0].equalsIgnoreCase("help");
    }

    void executeCommand(MessageReceivedEvent event, String[] commandArgs) {
        if (isCommand(event, commandArgs)) {
            commandMap.getCommand(commandArgs[0]).called(event, commandArgs);
            commandMap.getCommand(commandArgs[0]).runCommand(event, commandArgs);
            commandMap.getCommand(commandArgs[0]).executed(event, commandArgs);
        } else if (isHelpCommand(event, commandArgs)) {
           helpCommandMap.getHelpCommand(commandArgs[1]).called(event, commandArgs);
           helpCommandMap.getHelpCommand(commandArgs[1]).runCommand(event, commandArgs);
           helpCommandMap.getHelpCommand(commandArgs[1]).executed(event, commandArgs);
        }
    }

}
