package com.hnq.study.proxypattern.service.impl;

import com.hnq.study.proxypattern.service.Image;

/**
 * @author henengqiang
 * @date 2018/9/27
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName + " ...");
    }

}
