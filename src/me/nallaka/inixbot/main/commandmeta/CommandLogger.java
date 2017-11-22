package me.nallaka.inixbot.main.commandmeta;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandLogger {
    public void logCommand(MessageReceivedEvent event, String[] commandArgs) {
        System.out.println("[CommandInfo] " + commandArgs[0] + " command executed by " + event.getAuthor().getName() + " with the following args: ");
        for (String commandArg : commandArgs) {
            System.out.print(commandArg + " ");
        }
        System.out.println();
    }
}
