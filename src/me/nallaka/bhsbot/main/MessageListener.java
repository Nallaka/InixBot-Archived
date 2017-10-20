package me.nallaka.bhsbot.main;

import me.nallaka.bhsbot.maps.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    private CommandMaps commandMap = new CommandMaps();
    private HelpCommandMap helpCommandMap = new HelpCommandMap();
    private CommandHandler commandHandler = new CommandHandler();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String beheadedCommand = event.getMessage().getContent().replaceFirst(".", "").toLowerCase();
        String[] commandArgs = beheadedCommand.split("\\s");

        commandHandler.executeCommand(event, commandArgs);
    }
}