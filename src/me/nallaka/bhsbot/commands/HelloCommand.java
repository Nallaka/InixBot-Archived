package me.nallaka.bhsbot.commands;

import me.nallaka.bhsbot.main.Command;
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
        event.getTextChannel().sendMessage(messageBuilder.build()).queue();
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {
        System.out.println("Hello Command executed by: " + event.getAuthor().getName());
    }
}
