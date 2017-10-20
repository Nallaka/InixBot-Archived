package me.nallaka.bhsbot.main;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public interface Command {
    CommandLogger commandLogger = new CommandLogger();
    EmbedBuilder emebeddedMessageBuilder = new EmbedBuilder();
    boolean called(MessageReceivedEvent event, String[] args);
    void runCommand(MessageReceivedEvent event, String[] args);
    void executed(MessageReceivedEvent event, String[] args);
}
