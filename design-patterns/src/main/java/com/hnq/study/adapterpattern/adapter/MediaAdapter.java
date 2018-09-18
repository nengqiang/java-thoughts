package com.hnq.study.adapterpattern.adapter;

import com.hnq.study.adapterpattern.service.IAdvancedMediaPlayer;
import com.hnq.study.adapterpattern.service.IMediaPlayer;
import com.hnq.study.adapterpattern.service.impl.Mp4Player;
import com.hnq.study.adapterpattern.service.impl.VlcPlayer;

/**
 * @author henengqiang
 * @date 2018/9/18
 */
public class MediaAdapter implements IMediaPlayer {

    private static final String AUDIO_TYPE_VLC = "vlc";

    private static final String AUDIO_TYPE_MP4 = "mp4";

    private IAdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (AUDIO_TYPE_VLC.equalsIgnoreCase(audioType)) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (AUDIO_TYPE_MP4.equalsIgnoreCase(audioType)) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (AUDIO_TYPE_VLC.equalsIgnoreCase(audioType)) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (AUDIO_TYPE_MP4.equalsIgnoreCase(audioType)) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }



}
