package me.nallaka.inixBot.commands;

import me.nallaka.inixBot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PingCommand implements Command {
    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return false;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        event.getTextChannel().sendMessage(String.valueOf(event.getAuthor().getJDA().getPing()) + "ms").queue();
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {
        System.out.println("Ping Command executed by: " + event.getAuthor().getName());
    }
}
