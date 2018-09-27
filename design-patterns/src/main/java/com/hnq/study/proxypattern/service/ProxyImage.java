package com.hnq.study.proxypattern.service;

import com.hnq.study.proxypattern.service.impl.RealImage;

/**
 * @author henengqiang
 * @date 2018/9/27
 */
public class ProxyImage implements Image {

    private RealImage realImage;

    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }

}
