package me.nallaka.bhsBot.commands;

import me.nallaka.bhsBot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class JoinClassCommand implements Command {
    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return true;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        if (args.length < 2) {
            event.getTextChannel().sendMessage("USAGE: .joinclass [Class]");
        } else {
            /*event.getGuild().getRole
            event.getMember().getRoles().add()*/
        }
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {
        System.out.println("JoinClass Command executed by: " + event.getAuthor().getName());
    }
}
