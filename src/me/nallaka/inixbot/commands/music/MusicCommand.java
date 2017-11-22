package me.nallaka.inixbot.commands.music;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import me.nallaka.inixbot.main.commandmeta.Command;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class MusicCommand implements Command {
    private static final AudioPlayerManager playerManager = new DefaultAudioPlayerManager();
    private static AudioTrack audioTrack;

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        if (args.length < 2) {
            System.out.println("WTF");
            return;
        }

        String input = args[1];

        if (!(input.startsWith("http://") || input.startsWith("https://"))) {
            input = "ytsearch: " + input;
        }

        loadTrack(input, event.getMember(), event.getMessage());

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
