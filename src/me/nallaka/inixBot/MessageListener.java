package me.nallaka.inixBot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import static me.nallaka.inixBot.BotMain.commands;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String beheadedCommand = event.getMessage().getContent().replaceFirst(".", "");
        String[] commandArgs = beheadedCommand.split(" ");

        if (commands.containsKey(commandArgs[0].toLowerCase())) {
            commands.get(commandArgs[0]).runCommand(event, commandArgs);
        }
    }

   /*
    public  void helloCommand(MessageReceivedEvent event) {
        String name = event.getAuthor().getName();
        event.getTextChannel().sendMessage("Ey Yo " + name).queue();
    }*/
}