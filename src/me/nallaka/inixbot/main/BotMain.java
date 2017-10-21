package me.nallaka.inixbot.main;

import me.nallaka.inixbot.commands.help.HelloHelpCommand;
import me.nallaka.inixbot.commands.help.PingHelpCommand;
import me.nallaka.inixbot.maps.*;
import me.nallaka.inixbot.commands.*;
import me.nallaka.inixbot.commands.help.HelpCommand;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.EventListener;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BotMain extends ListenerAdapter implements EventListener {

    public static void main(String[] args) throws LoginException, InterruptedException, RateLimitedException, IOException {
        //Bot Setup
        Properties properties = new Properties();
        InputStream inputStream = BotMain.class.getClassLoader().getResourceAsStream("me/nallaka/inixbot/main/dataConfig.properties");
        properties.load(inputStream);

        String botToken = properties.getProperty("BOT_TOKEN");
        JDA jda = new JDABuilder(AccountType.BOT).setToken(botToken).buildBlocking();
        jda.addEventListener(new MessageHandler());

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
