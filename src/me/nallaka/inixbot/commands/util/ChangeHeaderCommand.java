package me.nallaka.inixbot.commands.util;

import me.nallaka.inixbot.main.BotMain;
import me.nallaka.inixbot.main.commandmeta.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class ChangeHeaderCommand implements Command {
    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        if (args.length > 1) {
            BotMain.COMMAND_PREFIX = args[1];
            embeddedMessageBuilder.addField("Command Header -", "Changed to ``" + args[1] + "``", true);
        } else if (args.length == 1) {
            embeddedMessageBuilder.addField("ERROR :no_entry:", "Input a New Header", true);
        }
        messageHandler.sendMessage(event, embeddedMessageBuilder);
        messageHandler.clearEmbeddedBuilder(embeddedMessageBuilder);
    }

    @Override
    public void runHelpCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("Change Command Header")
                .setDescription("Changes the Command Prefix")
                .addField("Usage", "``" + commandPrefix + "changeheader <header>``", true);
        messageHandler.sendMessage(event, embeddedMessageBuilder);
        messageHandler.clearEmbeddedBuilder(embeddedMessageBuilder);
    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        return false;
    }
}
