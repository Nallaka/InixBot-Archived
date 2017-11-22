package me.nallaka.inixbot.helpcommands.utilhelp;

import me.nallaka.inixbot.main.commandmeta.HelpCommand;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class RollDiceHelpCommand implements HelpCommand {
    @Override
    public void runHelpCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("Roll Dice :game_die:")
                .setDescription("Rolls a Die")
                .addField("Usage", "``" + commandPrefix + "rolldice <number>``", false);
        messageHandler.sendMessage(event, embeddedMessageBuilder)
                .clearEmbeddedBuilder(embeddedMessageBuilder);
    }
}
