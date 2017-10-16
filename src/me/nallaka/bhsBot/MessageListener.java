package me.nallaka.bhsBot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import static me.nallaka.bhsBot.BotMain.commands;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String beheadedCommand = event.getMessage().getContent().replaceFirst(".", "");
        String[] commandArgs = beheadedCommand.split("\\s");

        if (event.getAuthor().getJDA().getSelfUser() != event.getAuthor() && commands.containsKey(commandArgs[0].toLowerCase())) {
            commands.get(commandArgs[0]).runCommand(event, commandArgs);
            commands.get(commandArgs[0]).executed(event, commandArgs);
        }
    }
}