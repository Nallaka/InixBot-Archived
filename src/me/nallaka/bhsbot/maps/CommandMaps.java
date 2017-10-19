package me.nallaka.bhsbot.maps;

import me.nallaka.bhsbot.main.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandMaps {
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
