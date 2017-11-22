package me.nallaka.inixbot.helpcommands.utilhelp;

import me.nallaka.inixbot.main.commandmeta.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PingHelpCommand implements Command {
    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("Ping Command")
                .setDescription("Returns Your Ping")
                .addField("Usage", "``.ping``", true);
        messageHandler.sendMessage(event, embeddedMessageBuilder)
                .clearEmbeddedBuilder(embeddedMessageBuilder);
    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
        return true;
    }
}
