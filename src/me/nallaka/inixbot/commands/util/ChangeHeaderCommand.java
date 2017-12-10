package me.nallaka.inixbot.commands.util;

import me.nallaka.inixbot.main.BotMain;
import me.nallaka.inixbot.main.commandmeta.Command;
import me.nallaka.inixbot.main.permissionmeta.PermissionLevel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class ChangeHeaderCommand extends Command {
    public ChangeHeaderCommand(PermissionLevel permissionLevel) {
        super(permissionLevel);
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        if (args.length > 1) {
            BotMain.COMMAND_PREFIX = args[1];
            embeddedMessageBuilder.addField("Command Header -", "Changed to ``" + args[1] + "``", true);
        } else if (args.length == 1) {
            embeddedMessageBuilder.addField("ERROR :no_entry:", "Input a New Header", true);
        }
        messageHandler.sendMessage(event, embeddedMessageBuilder);
    }

    @Override
    public void runHelpCommand(MessageReceivedEvent event, String[] args) {
        messageHandler.sendHelpMessage(event, embeddedMessageBuilder, "Change Command Header :gear:", "Changes the Command Prefix", "changeheader <header>");
    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
        return false;
    }
}
