package me.nallaka.inixbot.registry;

import me.nallaka.inixbot.main.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private static Map<String, Command> commandMap = new HashMap<>();

    public void setCommand(String commandString, Command command) {
        commandMap.put(commandString, command);
    }

    public Command getCommand(String commandString) {
        return commandMap.get(commandString);
    }

    public boolean containsKey(String key) {
        return commandMap.containsKey(key);
    }
}
