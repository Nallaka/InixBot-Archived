package me.nallaka.inixbot.commands.util;

import me.nallaka.inixbot.main.commandmeta.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class RollDiceCommand implements Command {
    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        try {
            int diceArg = Integer.parseInt(args[1]);
            if (diceArg < 1000) {
                embeddedMessageBuilder.addField(":game_die: You Rolled -", Integer.toString((int) (Math.random() * Integer.parseInt(args[1]))), true);
            } else {
                embeddedMessageBuilder.addField("ERROR:", "Dice value too high. Please try again", true);
            }
            messageHandler.sendMessage(event, embeddedMessageBuilder);
            messageHandler.clearEmbeddedBuilder(embeddedMessageBuilder);
        } catch (ArrayIndexOutOfBoundsException e) {
            embeddedMessageBuilder.addField("ERROR -", "Input a dice value", true);
            e.printStackTrace();
        }
    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
        return true;
    }
}
