package me.nallaka.bhsBot.commands;

import me.nallaka.bhsBot.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PingCommand implements Command {
    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return true;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        EmbedBuilder messageBuilder = new EmbedBuilder().setTitle("Ping!")
                                                        .addField(new MessageEmbed.Field("Latency", Long.toString(event.getAuthor().getJDA().getPing()), true));
        event.getTextChannel().sendMessage(messageBuilder.build()).queue();
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {
        System.out.println("Ping Command executed by: " + event.getAuthor().getName());
    }
}
