package me.nallaka.bhsBot.commands;

import me.nallaka.bhsBot.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelloCommand implements Command {
    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return true;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        String name = event.getAuthor().getName();
        EmbedBuilder messageBuilder = new EmbedBuilder().addField("Hello!", name, true);
        event.getTextChannel().sendMessage(messageBuilder.build());
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {
        System.out.println("Hello Command executed by: " + event.getAuthor().getName());
    }
}
