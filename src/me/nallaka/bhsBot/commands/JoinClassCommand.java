package me.nallaka.bhsBot.commands;

import me.nallaka.bhsBot.Command;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.List;

public class JoinClassCommand implements Command {
    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return true;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        List<Role> Role = event.getAuthor().getJDA().getRoles();
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {
        System.out.println("JoinClass Command executed by: " + event.getAuthor().getName());
    }
}
