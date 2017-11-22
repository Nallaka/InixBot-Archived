package me.nallaka.inixbot.registry;

import me.nallaka.inixbot.main.commandmeta.HelpCommand;

import java.util.HashMap;

public class HelpCommandRegistryMeta {
    private static HashMap<String, HelpCommand> helpCommandMap = new HashMap<>();

    public void setHelpCommand(String commandString, HelpCommand command) {
        helpCommandMap.put(commandString, command);
    }

    public HelpCommand getHelpCommand(String commandString) {
        return helpCommandMap.get(commandString);
    }

    public boolean containsHelpKey(String key) {
        return helpCommandMap.containsKey(key);
    }
}
