package me.nallaka.inixbot.commands.util;

import me.nallaka.inixbot.main.commandmeta.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelpCommand implements Command {
    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("Help")
                .setDescription("Do ``_help <command>`` for more information");
        embeddedMessageBuilder.addField("Fun Commands", "``8ball``, ``hello``,", true);
        embeddedMessageBuilder.addField("Music Commands", "``music``, ", true);
        embeddedMessageBuilder.addField("Utility Commands", "``changeheader``, ``coin``, ``ping``, ``rolldice``", true);
        messageHandler.sendMessage(event, embeddedMessageBuilder);
        messageHandler.clearEmbeddedBuilder(embeddedMessageBuilder);
    }

    @Override
    public void runHelpCommand(MessageReceivedEvent event, String[] args) {

    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
        return true;
    }
}
