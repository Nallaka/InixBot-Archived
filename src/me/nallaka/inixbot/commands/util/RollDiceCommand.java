package me.nallaka.inixbot.commands.util;

import me.nallaka.inixbot.main.commandmeta.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class RollDiceCommand implements Command {
    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        try {
            int diceArg = Integer.parseInt(args[1]);
            embeddedMessageBuilder.setTitle("Dice Roll");
            if (diceArg < 1000) {
                embeddedMessageBuilder.addField("You Rolled :game_die::", Double.toString(Math.random() * Integer.parseInt(args[1])), true);
            } else {
                embeddedMessageBuilder.addField("ERROR:", "Dice value too high. Please try again", true);
            }
            messageHandler.sendMessage(event, embeddedMessageBuilder)
                    .clearEmbeddedBuilder(embeddedMessageBuilder);
        } catch (NumberFormatException e) {
            embeddedMessageBuilder.setTitle("Dice Roll").addField("ERROR:", "Use a number", true);
        }
    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
        return true;
    }
}
