package me.nallaka.inixbot.main;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandLogger {
    public void logCommand(MessageReceivedEvent event, String[] commandArgs) {
        //Prints author and all args of command to console
        System.out.println(commandArgs[0] + " Command executed by: " + event.getAuthor().getName() + " with the following args: ");
        for (String commandArg : commandArgs) {
            System.out.print(commandArg + " ");
        }
    }
}
