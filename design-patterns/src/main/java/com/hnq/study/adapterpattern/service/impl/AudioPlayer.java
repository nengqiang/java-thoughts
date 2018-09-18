package com.hnq.study.adapterpattern.service.impl;

import com.hnq.study.adapterpattern.adapter.MediaAdapter;
import com.hnq.study.adapterpattern.service.IMediaPlayer;

/**
 * @author henengqiang
 * @date 2018/9/18
 */
public class AudioPlayer implements IMediaPlayer {

    private static final String AUDIO_TYPE_MP3 = "mp3";

    private static final String AUDIO_TYPE_VLC = "vlc";

    private static final String AUDIO_TYPE_MP4 = "mp4";

    private IMediaPlayer mediaPlayer;

    @Override
    public void play(String audioType, String fileName) {
        // 播放 mp3 音乐文件的内置支持
        if (AUDIO_TYPE_MP3.equalsIgnoreCase(audioType)) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        }

        // mediaPlayer 提供了播放其他文件格式的支持
        else if (AUDIO_TYPE_VLC.equalsIgnoreCase(audioType) || AUDIO_TYPE_MP4.equalsIgnoreCase(audioType)) {
            mediaPlayer = new MediaAdapter(audioType);
            mediaPlayer.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported.");
        }
    }

}
