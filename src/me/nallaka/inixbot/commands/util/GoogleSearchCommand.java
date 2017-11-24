package me.nallaka.inixbot.commands.util;

import me.nallaka.inixbot.main.commandmeta.Command;
import me.nallaka.inixbot.main.commandmeta.PermissionLevel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class GoogleSearchCommand extends Command {
    public GoogleSearchCommand(PermissionLevel permissionLevel) {
        super(permissionLevel);
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("Search Results :mag_right:");
        if (args.length > 1) {
            String searchRequest = "";
            for (String s : args) {
                if (!s.equalsIgnoreCase("google")) {
                    searchRequest = s + " ";
                }
            }

            Elements links = null;
            try {
                String googleURL = "http://www.google.com/search?q=";
                String charset = "UTF-8";
                String userClient = "(+http://google.com/)";
                links = Jsoup.connect(googleURL + URLEncoder.encode(searchRequest, charset)).userAgent(userClient).get().select(".g>.r>a");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (links != null) {
                for (Element link : links) {
                    String title = link.text();
                    String url = link.absUrl("href");
                    try {
                        url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                    if (!url.startsWith("http")) {
                        continue;
                    }

                    embeddedMessageBuilder.addField(title, url,true);
                }
            }
        } else {
            embeddedMessageBuilder.addField("ERROR :no_entry:", "Input a Search", false);
        }
        messageHandler.sendMessage(event, embeddedMessageBuilder);
    }

    @Override
    public void runHelpCommand(MessageReceivedEvent event, String[] args) {
        messageHandler.sendHelpMessage(event, embeddedMessageBuilder, "Google Search :mag_right:", "Search Google", "google <search>");
    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
        return false;
    }
}
