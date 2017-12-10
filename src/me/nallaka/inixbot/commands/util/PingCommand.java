package me.nallaka.inixbot.commands.util;

import me.nallaka.inixbot.main.commandmeta.Command;
import me.nallaka.inixbot.main.permissionmeta.PermissionLevel;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PingCommand extends Command {
    public PingCommand(PermissionLevel permissionLevel) {
        super(permissionLevel);
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.addField(new MessageEmbed.Field("Pong! :ping_pong:", Long.toString(event.getAuthor().getJDA().getPing()) + "ms", true));
        messageHandler.sendMessage(event, embeddedMessageBuilder);
    }

    @Override
    public void runHelpCommand(MessageReceivedEvent event, String[] args) {
        messageHandler.sendHelpMessage(event, embeddedMessageBuilder, "Ping :ping_pong:", "Returns Latency", "ping");
    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
        return true;
    }
}
