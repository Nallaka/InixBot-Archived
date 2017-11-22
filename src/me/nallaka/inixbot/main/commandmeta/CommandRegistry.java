package me.nallaka.inixbot.main.commandmeta;

import me.nallaka.inixbot.commands.fun.HelloCommand;
import me.nallaka.inixbot.commands.music.MusicCommand;
import me.nallaka.inixbot.commands.util.PingCommand;
import me.nallaka.inixbot.commands.util.RollDiceCommand;
import me.nallaka.inixbot.commands.util.HelpCommand;
import me.nallaka.inixbot.helpcommands.funhelp.HelloHelpCommand;
import me.nallaka.inixbot.helpcommands.musichelp.MusicHelpCommand;
import me.nallaka.inixbot.helpcommands.utilhelp.PingHelpCommand;
import me.nallaka.inixbot.helpcommands.utilhelp.RollDiceHelpCommand;
import me.nallaka.inixbot.registry.CommandRegistryMeta;
import me.nallaka.inixbot.registry.HelpCommandRegistryMeta;

public class CommandRegistry {

    private CommandRegistryMeta commandRegistryMeta;
    private HelpCommandRegistryMeta helpCommandRegistryMeta;

    public CommandRegistry(CommandRegistryMeta commandRegistryMeta, HelpCommandRegistryMeta helpCommandRegistryMeta) {
        this.commandRegistryMeta = commandRegistryMeta;
        this.helpCommandRegistryMeta = helpCommandRegistryMeta;
    }

    public void setCommandRegistry() {
        commandRegistryMeta.setCommand("help", new HelpCommand());
        commandRegistryMeta.setCommand("ping", new PingCommand());
        commandRegistryMeta.setCommand("hello", new HelloCommand());
        commandRegistryMeta.setCommand("rolldice", new RollDiceCommand());
        commandRegistryMeta.setCommand("music", new MusicCommand());
    }

    public void setHelpCommandRegistry() {
        helpCommandRegistryMeta.setHelpCommand("ping", new PingHelpCommand());
        helpCommandRegistryMeta.setHelpCommand("hello", new HelloHelpCommand());
        helpCommandRegistryMeta.setHelpCommand("music", new MusicHelpCommand());
        helpCommandRegistryMeta.setHelpCommand("rolldice", new RollDiceHelpCommand());
    }
}
