package me.nallaka.inixbot.commands.fun;

import me.nallaka.inixbot.main.commandmeta.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelloCommand implements Command {
    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("Hello :wave:").setDescription(event.getMessage().getAuthor().getName());
        messageHandler.sendMessage(event, embeddedMessageBuilder);
    }

    @Override
    public void runHelpCommand(MessageReceivedEvent event, String[] args) {
        messageHandler.sendHelpMessage(event, embeddedMessageBuilder, "Hello", "Simply Says Hello", "hello");
    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
        return true;
    }
}
