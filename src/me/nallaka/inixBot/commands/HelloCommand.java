package me.nallaka.inixBot.commands;

import me.nallaka.inixBot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelloCommand implements Command {
    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return false;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        String name = event.getAuthor().getName();
        event.getTextChannel().sendMessage("Ey Yo " + name).queue();
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {
        System.out.println("Hello Command executed by: " + event.getAuthor().getName());
    }
}
