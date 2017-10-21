package me.nallaka.bhsbot.main;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandLogger {
    public void logCommand(MessageReceivedEvent event, String[] commandArgs) {
        System.out.println(commandArgs[0] + " Command executed by: " + event.getAuthor().getName() + " with the following args: ");
    }
}
