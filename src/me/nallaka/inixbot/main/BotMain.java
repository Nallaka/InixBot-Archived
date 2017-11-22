package me.nallaka.inixbot.main;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import me.nallaka.inixbot.main.commandmeta.CommandRegistry;
import me.nallaka.inixbot.registry.*;
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

    public static String COMMAND_PREFIX = "_";

    public static void main(String[] args) throws LoginException, InterruptedException, RateLimitedException, IOException {
        //Bot Setup
        Properties properties = new Properties();
        InputStream inputStream = BotMain.class.getClassLoader().getResourceAsStream("me/nallaka/inixbot/main/dataConfig.properties");
        properties.load(inputStream);

        String botToken = properties.getProperty("BOT_TOKEN");
        JDA jda = new JDABuilder(AccountType.BOT).setToken(botToken).buildBlocking();
        jda.addEventListener(new MessageHandler());

        //Command Registry Setup
        CommandRegistry commandRegistry = new CommandRegistry(new CommandRegistryMeta(), new HelpCommandRegistryMeta());

        commandRegistry.setCommandRegistry();
        commandRegistry.setHelpCommandRegistry();
    }
}
