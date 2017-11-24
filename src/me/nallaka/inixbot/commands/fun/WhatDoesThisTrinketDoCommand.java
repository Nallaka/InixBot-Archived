package me.nallaka.inixbot.commands.fun;

import me.nallaka.inixbot.main.commandmeta.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class WhatDoesThisTrinketDoCommand implements Command {
    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("AND THE TING GOES!").setDescription("SKRAAAAAAAAAAAAAAAAAAA");
        messageHandler.sendMessage(event, embeddedMessageBuilder);
    }

    @Override
    public void runHelpCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("You Don't Get No Help")
                .setDescription("No")
                .addField("2+2=4-1=3", "Quick Maths!", false);
        messageHandler.sendMessage(event, embeddedMessageBuilder);
    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
        return false;
    }
}
