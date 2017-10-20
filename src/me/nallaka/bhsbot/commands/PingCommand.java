package me.nallaka.bhsbot.commands;

import me.nallaka.bhsbot.main.Command;
import me.nallaka.bhsbot.main.CommandLogger;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PingCommand implements Command {
    CommandLogger commandLogger = new CommandLogger();

    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return true;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        emebeddedMessageBuilder.setTitle("Ping!").addField(new MessageEmbed.Field("Latency", Long.toString(event.getAuthor().getJDA().getPing()), true));
        event.getTextChannel().sendMessage(emebeddedMessageBuilder.build()).queue();
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
    }
}
