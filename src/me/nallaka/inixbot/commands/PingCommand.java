package me.nallaka.inixbot.commands;

import me.nallaka.inixbot.main.Command;
import me.nallaka.inixbot.main.CommandLogger;
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
        embeddedMessageBuilder.addField(new MessageEmbed.Field("Latency:", Long.toString(event.getAuthor().getJDA().getPing()) + "ms", true));
        event.getTextChannel().sendMessage(embeddedMessageBuilder.build()).queue();
        messageHandler.clearEmbeddedBuilder(embeddedMessageBuilder);
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
    }
}
