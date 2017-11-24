package me.nallaka.inixbot.main;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class MessageHandler {

    public void sendMessage(MessageReceivedEvent event, EmbedBuilder embedBuilder) {
        event.getTextChannel().sendMessage(embedBuilder.build()).queue();
        clearEmbeddedBuilder(embedBuilder);
    }

    public void sendHelpMessage(MessageReceivedEvent event, EmbedBuilder embedBuilder, String helpTitle, String helpDescription, String helpUsage) {
        embedBuilder.setTitle(helpTitle)
                .setDescription(helpDescription)
                .addField("Usage", "``" + BotMain.COMMAND_DEFAULT_PREFIX + helpUsage + "``", true);
        event.getTextChannel().sendMessage(embedBuilder.build()).queue();
        clearEmbeddedBuilder(embedBuilder);
    }

    public void clearEmbeddedBuilder(EmbedBuilder embedBuilder) {
        embedBuilder.setTitle(null).setDescription(null);
        embedBuilder.clearFields();
    }

}