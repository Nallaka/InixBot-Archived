package me.nallaka.inixbot.main.commandmeta;

import me.nallaka.inixbot.main.MessageHandler;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public interface Command {
    CommandLogger commandLogger = new CommandLogger();
    EmbedBuilder embeddedMessageBuilder = new EmbedBuilder().setColor(Color.CYAN).clearFields().setTitle(" ").setDescription(" ");
    MessageHandler messageHandler = new MessageHandler();
    void runCommand(MessageReceivedEvent event, String[] args);
    boolean executed(MessageReceivedEvent event, String[] args);
}
