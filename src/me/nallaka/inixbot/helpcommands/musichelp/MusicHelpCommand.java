package me.nallaka.inixbot.helpcommands.musichelp;

import me.nallaka.inixbot.main.commandmeta.HelpCommand;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class MusicHelpCommand implements HelpCommand {
    @Override
    public void runHelpCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("Help Command")
                .setDescription("Simply says hello!")
                .addField("Usage", "``" + commandPrefix + "music``", false);
        messageHandler.sendMessage(event, embeddedMessageBuilder);
        messageHandler.clearEmbeddedBuilder(embeddedMessageBuilder);
    }
}
