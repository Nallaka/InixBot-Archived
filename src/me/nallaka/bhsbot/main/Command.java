package me.nallaka.bhsbot.main;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public interface Command {
    CommandLogger commandLogger = new CommandLogger();
    EmbedBuilder embeddedMessageBuilder = new EmbedBuilder().setColor(Color.BLUE).clearFields().setTitle(" ").setDescription(" ");
    MessageHandler messageHandler = new MessageHandler();
    boolean called(MessageReceivedEvent event, String[] args);
    void runCommand(MessageReceivedEvent event, String[] args);
    void executed(MessageReceivedEvent event, String[] args);
}
