package me.nallaka.bhsBot;

import java.util.HashMap;
import java.util.Map;

public class CommandMap {
    private static Map<String, Command> commands = new HashMap<>();

    public void setCommand(String commandString, Command command) {
        commands.put(commandString, command);
    }

    public Command getCommand(String commandString) {
        return commands.get(commandString);
    }
}
