package me.nallaka.inixbot.main.commandmeta;

import me.nallaka.inixbot.commands.fun.EightBallCommand;
import me.nallaka.inixbot.commands.fun.HelloCommand;
import me.nallaka.inixbot.commands.fun.WhatDoesThisTrinketDoCommand;
import me.nallaka.inixbot.commands.music.MusicCommand;
import me.nallaka.inixbot.commands.util.*;

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

    public static Map<String, Command> getCommandMap() {
        return commandMap;
    }

    public boolean containsKey(String key) {
        return commandMap.containsKey(key);
    }

    public void setCommandRegistry() {
        setCommand("help", new HelpCommand());
        setCommand("ping", new PingCommand());
        setCommand("hello", new HelloCommand());
        setCommand("rolldice", new RollDiceCommand());
        setCommand("music", new MusicCommand());
        setCommand("coin", new CoinFlipCommand());
        setCommand("8ball", new EightBallCommand());
        setCommand("changeheader", new ChangeHeaderCommand());
        setCommand("whatdoesthistrinketdo", new WhatDoesThisTrinketDoCommand());
        setCommand("google", new GoogleSearchCommand());
    }
}
