package me.nallaka.bhsBot.commands.Help;

import me.nallaka.bhsBot.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class HelpCommand implements Command {

    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return true;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        EmbedBuilder messageBuilder = new EmbedBuilder().setTitle("Help Commands")
                                                        .setDescription("All the help commands")
                                                        .setColor(Color.RED)
                                                        .addField("Empty", "I'm pretty empty. Come back later when I can do more stuff!", true);
        event.getTextChannel().sendMessage(messageBuilder.build()).queue();
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {
        System.out.println("Help Command executed by: " + event.getAuthor().getName());
    }
}
