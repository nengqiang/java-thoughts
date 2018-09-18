package com.hnq.study.adapterpattern.service.impl;

import com.hnq.study.adapterpattern.service.IAdvancedMediaPlayer;

/**
 * @author henengqiang
 * @date 2018/9/18
 */
public class VlcPlayer implements IAdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // do nothing
    }

}
