package me.nallaka.inixbot.commands.util;

import me.nallaka.inixbot.main.commandmeta.Command;
import me.nallaka.inixbot.main.permissionmeta.PermissionLevel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class RollDiceCommand extends Command {
    public RollDiceCommand(PermissionLevel permissionLevel) {
        super(permissionLevel);
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        try {
            int diceArg = Integer.parseInt(args[1]);
            if (diceArg < 1000) {
                embeddedMessageBuilder.addField("You Rolled :game_die:", Integer.toString((int) (Math.random() * Integer.parseInt(args[1]))), true);
            } else {
                embeddedMessageBuilder.addField("ERROR :game_die:", "Dice value too high. Please try again", true);
            }
            messageHandler.sendMessage(event, embeddedMessageBuilder);
            messageHandler.clearEmbeddedBuilder(embeddedMessageBuilder);
        } catch (ArrayIndexOutOfBoundsException e) {
            embeddedMessageBuilder.addField("ERROR :game_die:", "Input a dice value", true);
            messageHandler.sendMessage(event, embeddedMessageBuilder);
        }
    }

    @Override
    public void runHelpCommand(MessageReceivedEvent event, String[] args) {
        messageHandler.sendHelpMessage(event, embeddedMessageBuilder, "Roll Dice :game_die:", "Rolls a Die", "rolldice <number>");
    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
        return true;
    }
}
