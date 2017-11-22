package me.nallaka.inixbot.helpcommands.funhelp;

import me.nallaka.inixbot.main.commandmeta.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelloHelpCommand implements Command {
    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("Hello Command")
                .setDescription("Simply says hello!")
                .addField("Usage", "``.hello``", false);
        messageHandler.sendMessage(event, embeddedMessageBuilder);
        messageHandler.clearEmbeddedBuilder(embeddedMessageBuilder);
    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
        return true;
    }
}
