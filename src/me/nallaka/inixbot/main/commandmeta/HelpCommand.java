package me.nallaka.inixbot.main.commandmeta;

import me.nallaka.inixbot.main.BotMain;
import me.nallaka.inixbot.main.MessageHandler;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public interface HelpCommand {
    String commandPrefix = BotMain.COMMAND_PREFIX;
    EmbedBuilder embeddedMessageBuilder = new EmbedBuilder().setColor(Color.CYAN).clearFields().setTitle(null).setDescription(null);
    MessageHandler messageHandler = new MessageHandler();

    void runHelpCommand(MessageReceivedEvent event, String[] args);
}
