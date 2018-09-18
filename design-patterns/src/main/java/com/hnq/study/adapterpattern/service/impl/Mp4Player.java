package com.hnq.study.adapterpattern.service.impl;

import com.hnq.study.adapterpattern.service.IAdvancedMediaPlayer;

/**
 * @author henengqiang
 * @date 2018/9/18
 */
public class Mp4Player implements IAdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        // do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("playing mp4 file. Name: " + fileName);
    }

}
