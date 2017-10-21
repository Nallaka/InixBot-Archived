package me.nallaka.inixbot.maps;

import me.nallaka.inixbot.main.Command;

import java.util.HashMap;

public class HelpCommandMap {
    private static HashMap<String, Command> helpCommandMap = new HashMap<>();

    public void setHelpCommand(String commandString, Command command) {
        helpCommandMap.put(commandString, command);
    }

    public Command getHelpCommand(String commandString) {
        return helpCommandMap.get(commandString);
    }

    public boolean containsHelpKey(String key) {
        return helpCommandMap.containsKey(key);
    }
}
