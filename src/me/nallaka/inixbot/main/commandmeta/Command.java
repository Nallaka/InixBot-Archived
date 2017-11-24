package me.nallaka.inixbot.main.commandmeta;

import me.nallaka.inixbot.main.BotMain;
import me.nallaka.inixbot.main.MessageHandler;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public abstract class Command {
    public CommandLogger commandLogger = new CommandLogger();
    public EmbedBuilder embeddedMessageBuilder = new EmbedBuilder().setColor(Color.CYAN).clearFields().setTitle(null).setDescription(null);
    public MessageHandler messageHandler = new MessageHandler();
    protected String commandPrefix = BotMain.COMMAND_PREFIX;
    private PermissionLevel permissionLevel;

    public abstract void runCommand(MessageReceivedEvent event, String[] args);

    public abstract void runHelpCommand(MessageReceivedEvent event, String[] args);

    public abstract boolean executed(MessageReceivedEvent event, String[] args);

    public Command(PermissionLevel permissionLevel) {
        this.permissionLevel = permissionLevel;
    }
}
