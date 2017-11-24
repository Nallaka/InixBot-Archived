package me.nallaka.inixbot.commands.fun;

import me.nallaka.inixbot.main.commandmeta.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class EightBallCommand implements Command {
    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        String eightBallResponse = "";
        if (args.length > 1) {
            switch ((int) (Math.random() * 20 + 1)) {
                case 1:
                    eightBallResponse = "It is certain";
                    break;
                case 2:
                    eightBallResponse = "It is decidedly so";
                    break;
                case 3:
                    eightBallResponse = "Without a doubt";
                    break;
                case 4:
                    eightBallResponse = "Yes definitely";
                    break;
                case 5:
                    eightBallResponse = "You may rely on it";
                    break;
                case 6:
                    eightBallResponse = "As I see it, yes";
                    break;
                case 7:
                    eightBallResponse = "Most likely";
                    break;
                case 8:
                    eightBallResponse = "Outlook good";
                    break;
                case 9:
                    eightBallResponse = "Yes";
                    break;
                case 10:
                    eightBallResponse = "Signs point to yes";
                    break;
                case 11:
                    eightBallResponse = "Reply hazy try again";
                    break;
                case 12:
                    eightBallResponse = "Ask again later";
                    break;
                case 13:
                    eightBallResponse = "Better not tell you now";
                    break;
                case 14:
                    eightBallResponse = "Cannot predict now";
                    break;
                case 15:
                    eightBallResponse = "Concentrate and ask again";
                    break;
                case 16:
                    eightBallResponse = "Don't count on it";
                    break;
                case 17:
                    eightBallResponse = "My reply is no";
                    break;
                case 18:
                    eightBallResponse = "My sources say no ";
                    break;
                case 19:
                    eightBallResponse = "Outlook not so good";
                    break;
                case 20:
                    eightBallResponse = "Very doubtful";
                    break;
            }
        } else {
            eightBallResponse = "I'll need a question";
        }
        embeddedMessageBuilder.addField(":8ball: says", eightBallResponse, true);
        messageHandler.sendMessage(event, embeddedMessageBuilder);
    }

    @Override
    public void runHelpCommand(MessageReceivedEvent event, String[] args) {
        messageHandler.sendHelpMessage(event, embeddedMessageBuilder, "8 Ball :8ball:", "You Ask, It Answers", "8ball");
    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
        return false;
    }
}
