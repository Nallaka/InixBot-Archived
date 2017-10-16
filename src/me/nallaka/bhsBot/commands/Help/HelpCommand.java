package me.nallaka.bhsBot.commands.Help;

import me.nallaka.bhsBot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelpCommand implements Command {

    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return true;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        event.getTextChannel().sendMessage("Can't really do much right now. Maybe come back later?").queue();
        if (args.length >= 2) {
            String commandArg1 = args[1];
        }
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {
        System.out.println("Help Command executed by: " + event.getAuthor().getName());
    }
}
