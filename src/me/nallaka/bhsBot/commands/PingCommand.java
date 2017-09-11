package me.nallaka.bhsBot.commands;

import me.nallaka.bhsBot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PingCommand implements Command {
    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return true;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        event.getTextChannel().sendMessage(String.valueOf("Pong!: " + event.getAuthor().getJDA().getPing()) + "ms").queue();
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {
        System.out.println("Ping Command executed by: " + event.getAuthor().getName());
    }
}
