package me.nallaka.inixbot.main;

import me.nallaka.inixbot.commands.fun.HelloCommand;
import me.nallaka.inixbot.commands.util.PingCommand;
import me.nallaka.inixbot.commands.util.RollDiceCommand;
import me.nallaka.inixbot.helpcommands.HelpCommand;
import me.nallaka.inixbot.helpcommands.funhelp.HelloHelpCommand;
import me.nallaka.inixbot.helpcommands.utilhelp.PingHelpCommand;
import me.nallaka.inixbot.maps.CommandMap;
import me.nallaka.inixbot.maps.HelpCommandMap;

public class CommandRegistry {

    private CommandMap commandMap;
    private HelpCommandMap helpCommandMap;

    public CommandRegistry(CommandMap commandMap, HelpCommandMap helpCommandMap) {
        this.commandMap = commandMap;
        this.helpCommandMap = helpCommandMap;
    }

    public void setCommandRegistry() {
        commandMap.setCommand("helpcommands", new HelpCommand());
        commandMap.setCommand("ping", new PingCommand());
        commandMap.setCommand("hello", new HelloCommand());
        commandMap.setCommand("rolldice", new RollDiceCommand());
    }

    public void setHelpCommandRegistry() {
        helpCommandMap.setHelpCommand("ping", new PingHelpCommand());
        helpCommandMap.setHelpCommand("hello", new HelloHelpCommand());
    }
}
