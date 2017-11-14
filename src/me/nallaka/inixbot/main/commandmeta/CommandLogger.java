package me.nallaka.inixbot.main.commandmeta;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandLogger {
    public void logCommand(MessageReceivedEvent event, String[] commandArgs) {
        System.out.println(commandArgs[0] + " command executed by: " + event.getAuthor().getName() + "\nArgs: ");
        for (String commandArg : commandArgs) {
            System.out.print(commandArg + " ");
        }
    }
}
