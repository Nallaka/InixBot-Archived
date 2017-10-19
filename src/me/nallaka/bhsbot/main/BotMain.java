package me.nallaka.bhsbot.main;

import me.nallaka.bhsbot.commands.help.HelloHelpCommand;
import me.nallaka.bhsbot.commands.help.PingHelpCommand;
import me.nallaka.bhsbot.maps.*;
import me.nallaka.bhsbot.commands.*;
import me.nallaka.bhsbot.commands.help.HelpCommand;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.EventListener;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class BotMain extends ListenerAdapter implements EventListener {

    public static void main(String[] args) throws LoginException, InterruptedException, RateLimitedException {
        //Bot Setup
        String botToken = "MzU2MjY5MTQ5NjAyOTcxNjQ5.DJY5Cg.OQONQOwYNjvVaQdjBsGXLf5JMmk";
        JDA jda = new JDABuilder(AccountType.BOT).setToken(botToken).buildBlocking();
        jda.addEventListener(new MessageListener());

        //Commands HashMap Setup
        CommandMaps commandMap = new CommandMaps();
        HelpCommandMap helpCommandMap = new HelpCommandMap();

        commandMap.setCommand("help", new HelpCommand());
        commandMap.setCommand("ping", new PingCommand());
        commandMap.setCommand("hello", new HelloCommand());

        helpCommandMap.setHelpCommand("ping", new PingHelpCommand());
        helpCommandMap.setHelpCommand("hello", new HelloHelpCommand());
    }
}
