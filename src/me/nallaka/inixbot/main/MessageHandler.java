package me.nallaka.inixbot.main;

import me.nallaka.inixbot.maps.*;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageHandler extends ListenerAdapter {

    private CommandHandler commandHandler = new CommandHandler();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        //Checks if message indicates a command
        if(event.getMessage().getContent().startsWith(".")) {
            //Replaces command header with nothing and splits the message along all spaces
            String beheadedCommand = event.getMessage().getContent().replaceFirst(".", "").toLowerCase();
            String[] commandArgs = beheadedCommand.split("\\s");

            commandHandler.executeCommand(event, commandArgs);
        }

    }

    //Clears embeddedBuilders after use
    public void clearEmbeddedBuilder(EmbedBuilder embedBuilder) {
        embedBuilder.setTitle(null).setDescription(null);
        embedBuilder.clearFields();
    }
}