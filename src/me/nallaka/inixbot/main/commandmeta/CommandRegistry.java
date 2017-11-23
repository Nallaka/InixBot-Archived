package me.nallaka.inixbot.main.commandmeta;

import me.nallaka.inixbot.commands.fun.EightBallCommand;
import me.nallaka.inixbot.commands.fun.HelloCommand;
import me.nallaka.inixbot.commands.music.MusicCommand;
import me.nallaka.inixbot.commands.util.*;
import me.nallaka.inixbot.commands.util.HelpCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {

    private static Map<String, Command> commandMap = new HashMap<>();

    public void setCommand(String commandString, Command command, Map<String, Command> commandMap) {
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

    public void setCommandRegistry() {
        setCommand("help", new HelpCommand(), commandMap);
        setCommand("ping", new PingCommand(), commandMap);
        setCommand("hello", new HelloCommand(), commandMap);
        setCommand("rolldice", new RollDiceCommand(), commandMap);
        setCommand("music", new MusicCommand(), commandMap);
        setCommand("coin", new CoinFlipCommand(), commandMap);
        setCommand("8ball", new EightBallCommand(), commandMap);
        setCommand("changeheader", new ChangeHeaderCommand(), commandMap);
    }
}
