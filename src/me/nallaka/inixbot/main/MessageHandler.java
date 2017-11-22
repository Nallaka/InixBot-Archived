package me.nallaka.inixbot.main;

import me.nallaka.inixbot.main.commandmeta.CommandHandler;
import net.dv8tion.jda.client.entities.Application;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageHandler extends ListenerAdapter {

    private CommandHandler commandHandler = new CommandHandler();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContent().startsWith(BotMain.COMMAND_PREFIX)) {
            String beheadedCommand = event.getMessage().getContent().replaceFirst(BotMain.COMMAND_PREFIX, "").toLowerCase();
            String[] commandArgs = beheadedCommand.split("\\s");

            commandHandler.executeCommand(event, commandArgs);
        }
    }

    public void clearEmbeddedBuilder(EmbedBuilder embedBuilder) {
        embedBuilder.setTitle(null).setDescription(null);
        embedBuilder.clearFields();
    }

    public void sendMessage(MessageReceivedEvent event, EmbedBuilder embedBuilder) {
        event.getTextChannel().sendMessage(embedBuilder.build()).queue();
    }
}