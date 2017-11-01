package me.nallaka.inixbot.main;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public interface Command {
    //Creating a Command Logger for each command
    CommandLogger commandLogger = new CommandLogger();
    //Creates embededMessageBuilder to use across commands
    EmbedBuilder embeddedMessageBuilder = new EmbedBuilder().setColor(Color.BLUE).clearFields().setTitle(" ").setDescription(" ");
    //Creates messageHandler to use across commands
    MessageHandler messageHandler = new MessageHandler();
    //Returns if the command has just been called
    boolean called(MessageReceivedEvent event, String[] args);
    //Runs when the command is called by player
    void runCommand(MessageReceivedEvent event, String[] args);
    //Runs after player calls command. Tracks command
    void executed(MessageReceivedEvent event, String[] args);
}
