package me.nallaka.inixbot.commands;

import me.nallaka.inixbot.main.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class RollDiceCommand implements Command {

    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return false;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        if (Integer.parseInt(args[1]) < 1000) {
            embeddedMessageBuilder.setTitle("Dice Roll").addField("You Rolled: Dice", Double.toString(Math.random() * Integer.parseInt(args[1])), true);
            Math.random();
        }
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {

    }
}
