package me.nallaka.inixbot.helpcommands.utilhelp;

import me.nallaka.inixbot.main.commandmeta.HelpCommand;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CoinFlipHelpCommand implements HelpCommand {
    @Override
    public void runHelpCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("Coin Flip")
                .setDescription("Flips a Coin")
                .addField("Usage", "``" + commandPrefix + "coinflip``", false);
        messageHandler.sendMessage(event, embeddedMessageBuilder);
        messageHandler.clearEmbeddedBuilder(embeddedMessageBuilder);
    }
}
