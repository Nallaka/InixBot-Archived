package me.nallaka.inixBot.commands;

import me.nallaka.inixBot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelpCommand implements Command {

    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return true;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        event.getTextChannel().sendMessage("Can't really do much right now. Maybe come back later?").queue();
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {

    }
}
