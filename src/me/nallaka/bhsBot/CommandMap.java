package me.nallaka.bhsBot;

import java.util.HashMap;
import java.util.Map;

class CommandMap {
    private static Map<String, Command> commands = new HashMap<>();

    void setCommand(String commandString, Command command) {
        commands.put(commandString, command);
    }

    Command getCommand(String commandString) {
        return commands.get(commandString);
    }

    boolean containsKey(String key) {
        return commands.containsKey(key);
    }
}
