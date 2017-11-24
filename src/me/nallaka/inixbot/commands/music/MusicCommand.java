package me.nallaka.inixbot.commands.music;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import me.nallaka.inixbot.main.commandmeta.Command;
import me.nallaka.inixbot.main.permissionmeta.PermissionLevel;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class MusicCommand extends Command {
    private static final AudioPlayerManager playerManager = new DefaultAudioPlayerManager();
    private static AudioTrack audioTrack;

    public MusicCommand(PermissionLevel permissionLevel) {
        super(permissionLevel);
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        if (args.length < 2) {
            System.out.println("WTF");
            return;
        }

        String input="";

        for(String s: args) {
            input = s + " ";
        }

        input.replaceFirst("music ", "");

        if (!(input.startsWith("http://") || input.startsWith("https://"))) {
            input = "ytsearch: " + input;
        }

        loadTrack(input, event.getMember(), event.getMessage());

    }

    @Override
    public void runHelpCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("Music :musical_note:")
                .setDescription("Music Commands")
                .addField("Usage", "``" + commandPrefix + "music``", false);
        messageHandler.sendMessage(event, embeddedMessageBuilder);
        messageHandler.clearEmbeddedBuilder(embeddedMessageBuilder);
    }

    @Override
    public boolean executed(MessageReceivedEvent event, String[] args) {
        return false;
    }

    private void loadTrack(String identifier, final Member author, Message msg) {
        Guild guild = author.getGuild();
        AudioPlayer player = playerManager.createPlayer();
        final TrackManager trackManager = new TrackManager(player);
        playerManager.loadItemOrdered(guild, identifier, new AudioLoadResultHandler() {
            @Override
            public void trackLoaded(AudioTrack audioTrack) {
                MusicCommand.audioTrack = audioTrack;
                trackManager.queue(audioTrack, author);
            }

            @Override
            public void playlistLoaded(AudioPlaylist audioPlaylist) {

            }

            @Override
            public void noMatches() {

            }

            @Override
            public void loadFailed(FriendlyException e) {
                e.printStackTrace();
            }
        });
        trackManager.queue(MusicCommand.audioTrack, author);
    }
}
