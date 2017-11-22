package me.nallaka.inixbot.commands.util;

import me.nallaka.inixbot.main.commandmeta.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CoinFlip implements Command {
    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        int random = (int) (Math.random()*1000);
        String flip;
        if (random % 2 == 0) {
            flip = "Heads";
        } else {
            flip = "Tails";
        }
        embeddedMessageBuilder.addField("You Flipped - ", flip, true);
        embeddedMessageBuilder.clearFields();
        messageHandler.sendMessage(event, embeddedMessageBuilder);
        messageHandler.clearEmbeddedBuilder(embeddedMessageBuilder);
    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        return false;
    }
}
