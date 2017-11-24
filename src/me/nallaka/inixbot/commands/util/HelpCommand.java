package me.nallaka.inixbot.commands.util;

import me.nallaka.inixbot.main.commandmeta.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelpCommand implements Command {
    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("Help")
                .setDescription("Do ``_help <command>`` for more information");
        embeddedMessageBuilder.addField("Fun Commands :boom:", "``8ball``, ``hello``,", true);
        embeddedMessageBuilder.addField("Music Commands :musical_note:", "``music``, ", true);
        embeddedMessageBuilder.addField("Utility Commands :tools:", "``changeheader``, ``coin``, ``ping``, ``rolldice``", true);
        messageHandler.sendMessage(event, embeddedMessageBuilder);
    }

    @Override
    public void runHelpCommand(MessageReceivedEvent event, String[] args) {
        messageHandler.sendHelpMessage(event, embeddedMessageBuilder, "Help", "Helps you with Help?", "help help");
    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
        return true;
    }
}
