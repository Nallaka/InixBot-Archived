package me.nallaka.inixbot.main.commandmeta;

import me.nallaka.inixbot.registry.CommandRegistryMeta;
import me.nallaka.inixbot.registry.HelpCommandRegistryMeta;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandHandler {
    private CommandRegistryMeta commandRegistryMeta = new CommandRegistryMeta();
    private HelpCommandRegistryMeta helpCommandRegistryMeta = new HelpCommandRegistryMeta();

    private boolean isCommand(MessageReceivedEvent event, String[] commandArgs) {
        return event.getAuthor().getJDA().getSelfUser() != event.getAuthor() && commandRegistryMeta.containsKey(commandArgs[0].toLowerCase()) && !commandArgs[0].equalsIgnoreCase("help");
    }

    private boolean isHelpCommand(MessageReceivedEvent event, String[] commandArgs) {
        return event.getAuthor().getJDA().getSelfUser() != event.getAuthor() && commandArgs[0].equalsIgnoreCase("help");
    }

    public void executeCommand(MessageReceivedEvent event, String[] commandArgs) {
        if (isCommand(event, commandArgs) || isHelpCommand(event, commandArgs) && commandArgs.length == 1) {
            commandRegistryMeta.getCommand(commandArgs[0]).runCommand(event, commandArgs);
            commandRegistryMeta.getCommand(commandArgs[0]).executed(event, commandArgs);
        } else if (isHelpCommand(event, commandArgs) && commandArgs.length >= 1) {
            helpCommandRegistryMeta.getHelpCommand(commandArgs[1]).runCommand(event, commandArgs);
            helpCommandRegistryMeta.getHelpCommand(commandArgs[1]).executed(event, commandArgs);
        }
    }

}
