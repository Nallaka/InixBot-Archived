package me.nallaka.inixbot.helpcommands.funhelp;

import me.nallaka.inixbot.main.commandmeta.HelpCommand;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class EightBallHelpCommand implements HelpCommand {
    @Override
    public void runHelpCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("8 Ball :8ball:")
                .setDescription("You Ask, It Answers")
                .addField("Usage", "``" + commandPrefix + "8ball``", false);
        messageHandler.sendMessage(event, embeddedMessageBuilder);
        messageHandler.clearEmbeddedBuilder(embeddedMessageBuilder);
    }
}
