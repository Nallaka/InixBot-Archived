package me.nallaka.bhsbot.commands.help;

import me.nallaka.bhsbot.main.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class PingHelpCommand implements Command {
    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return false;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        EmbedBuilder messageBuilder = new EmbedBuilder().setTitle("Ping Command")
                .setDescription("Returns Your Ping")
                .setColor(Color.RED)
                .addField("Usage", ".ping", true);
        event.getTextChannel().sendMessage(messageBuilder.build()).queue();
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {

    }
}
