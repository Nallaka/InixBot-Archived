package me.nallaka.inixbot.commands.music;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.core.entities.Member;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TrackManager extends AudioEventAdapter {
    private static AudioPlayer PLAYER = null;
    private static Queue<AudioInfo> queue = null;

    public TrackManager(AudioPlayer PLAYER) {
        this.PLAYER = PLAYER;
        this.queue = new LinkedBlockingQueue<>();
    }

    public void queue(AudioTrack track, Member author) {
        queue.add(new AudioInfo(track, author));

        if (PLAYER.getPlayingTrack() == null) {
            PLAYER.playTrack(track);
        }
    }
}
