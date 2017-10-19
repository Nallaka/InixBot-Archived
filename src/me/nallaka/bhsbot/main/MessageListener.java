package me.nallaka.bhsbot.main;

import me.nallaka.bhsbot.maps.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        CommandMaps commandMap = new CommandMaps();
        HelpCommandMap helpCommandMap = new HelpCommandMap();
        String beheadedCommand = event.getMessage().getContent().replaceFirst(".", "").toLowerCase();
        String[] commandArgs = beheadedCommand.split("\\s");

        if (event.getAuthor().getJDA().getSelfUser() != event.getAuthor() && commandMap.containsKey(commandArgs[0].toLowerCase()) && !commandArgs[0].equalsIgnoreCase("help")) {
            commandMap.getCommand(commandArgs[0]).called(event, commandArgs);
            commandMap.getCommand(commandArgs[0]).runCommand(event, commandArgs);
            commandMap.getCommand(commandArgs[0]).executed(event, commandArgs);
        } else if (event.getAuthor().getJDA().getSelfUser() != event.getAuthor() && helpCommandMap.containsHelpKey(commandArgs[1].toLowerCase()) && commandArgs[0].equalsIgnoreCase("help")) {
            helpCommandMap.getHelpCommand(commandArgs[1]).called(event, commandArgs);
            helpCommandMap.getHelpCommand(commandArgs[1]).runCommand(event, commandArgs);
            helpCommandMap.getHelpCommand(commandArgs[1]).executed(event, commandArgs);
        }
    }
}