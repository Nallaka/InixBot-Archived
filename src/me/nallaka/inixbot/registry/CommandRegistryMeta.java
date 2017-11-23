package me.nallaka.inixbot.registry;

import me.nallaka.inixbot.main.commandmeta.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistryMeta {
    private static Map<String, Command> commandMap = new HashMap<>();

    public void setCommand(String commandString, Command command) {
        commandMap.put(commandString, command);
    }

    public Command getCommand(String commandString) {
        return commandMap.get(commandString);
    }

    public static Map<String, Command> getCommandMap() {
        return commandMap;
    }

    public boolean containsKey(String key) {
        return commandMap.containsKey(key);
    }
}
