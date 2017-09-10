package me.nallaka.bhsBot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public interface Command {
    boolean called(MessageReceivedEvent event, String[] args);
    void runCommand(MessageReceivedEvent event, String[] args);
    void executed(MessageReceivedEvent event, String[] args);
}
