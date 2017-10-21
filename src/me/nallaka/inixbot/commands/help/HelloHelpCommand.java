package me.nallaka.inixbot.commands.help;

import me.nallaka.inixbot.main.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelloHelpCommand implements Command {
    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return false;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("Hello Command")
                .setDescription("Simply says hello!")
                .addField("Usage", "``.hello``", true);
        event.getTextChannel().sendMessage(embeddedMessageBuilder.build()).queue();
        messageHandler.clearEmbeddedBuilder(embeddedMessageBuilder);
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
    }
}
