package me.nallaka.inixbot.main.commandmeta;

import me.nallaka.inixbot.main.BotMain;
import me.nallaka.inixbot.main.permissionmeta.Permissions;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CommandHandler extends ListenerAdapter {
    private CommandRegistry commandRegistry;
    Permissions permissions;

    private boolean isCommand(MessageReceivedEvent event, String[] commandArgs) {
        return event.getAuthor().getJDA().getSelfUser() != event.getAuthor() && commandRegistry.containsKey(commandArgs[0].toLowerCase()) && !commandArgs[0].equalsIgnoreCase("help");
    }

    private boolean isHelpCommand(MessageReceivedEvent event, String[] commandArgs) {
        return event.getAuthor().getJDA().getSelfUser() != event.getAuthor() && commandArgs[0].equalsIgnoreCase("help");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String beheadedCommand;
        if (event.getMessage().getContent().startsWith(BotMain.COMMAND_PREFIX)) {
            beheadedCommand = event.getMessage().getContent().replaceFirst(BotMain.COMMAND_PREFIX, "").toLowerCase();
            String[] commandArgs = beheadedCommand.split("\\s");

            executeCommand(event, commandArgs);
        } else if(event.getMessage().getContent().startsWith(BotMain.COMMAND_DEFAULT_PREFIX)) {
            beheadedCommand = event.getMessage().getContent().replaceFirst(BotMain.COMMAND_DEFAULT_PREFIX, "").toLowerCase();
            String[] commandArgs = beheadedCommand.split("\\s");

            executeCommand(event, commandArgs);
        }

    }

    private void executeCommand(MessageReceivedEvent event, String[] commandArgs) {
        User user = event.getAuthor();
        Command command = commandRegistry.getCommand(commandArgs[0]);
        if (isCommand(event, commandArgs) || isHelpCommand(event, commandArgs) && commandArgs.length == 1 && permissions.userHasCommandPermission(user, command)) {
            command.runCommand(event, commandArgs);
            command.executed(event, commandArgs);
        } else if (isHelpCommand(event, commandArgs) && permissions.userHasCommandPermission(user, command)) {
            commandRegistry.getCommand(commandArgs[1]).runHelpCommand(event, commandArgs);
            command.executed(event, commandArgs);
        }
    }


}
