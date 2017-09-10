package me.nallaka.bhsBot.commands;

import me.nallaka.bhsBot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class JoinClassCommand implements Command {
    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return false;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {

    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {
        System.out.println("JoinClass Command executed by: " + event.getAuthor().getName());
    }
}
