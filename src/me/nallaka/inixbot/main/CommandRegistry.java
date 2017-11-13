package me.nallaka.inixbot.main;

import me.nallaka.inixbot.commands.fun.HelloCommand;
import me.nallaka.inixbot.commands.util.PingCommand;
import me.nallaka.inixbot.commands.util.RollDiceCommand;
import me.nallaka.inixbot.helpcommands.HelpCommand;
import me.nallaka.inixbot.helpcommands.funhelp.HelloHelpCommand;
import me.nallaka.inixbot.helpcommands.utilhelp.PingHelpCommand;
import me.nallaka.inixbot.registry.HelpCommandRegistry;

public class CommandRegistry {

    private me.nallaka.inixbot.registry.CommandRegistry commandRegistry;
    private HelpCommandRegistry helpCommandRegistry;

    public CommandRegistry(me.nallaka.inixbot.registry.CommandRegistry commandRegistry, HelpCommandRegistry helpCommandRegistry) {
        this.commandRegistry = commandRegistry;
        this.helpCommandRegistry = helpCommandRegistry;
    }

    public void setCommandRegistry() {
        commandRegistry.setCommand("helpcommands", new HelpCommand());
        commandRegistry.setCommand("ping", new PingCommand());
        commandRegistry.setCommand("hello", new HelloCommand());
        commandRegistry.setCommand("rolldice", new RollDiceCommand());
    }

    public void setHelpCommandRegistry() {
        helpCommandRegistry.setHelpCommand("ping", new PingHelpCommand());
        helpCommandRegistry.setHelpCommand("hello", new HelloHelpCommand());
    }
}
