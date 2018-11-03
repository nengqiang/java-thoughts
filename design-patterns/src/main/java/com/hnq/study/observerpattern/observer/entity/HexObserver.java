package com.hnq.study.observerpattern.observer.entity;

import com.hnq.study.observerpattern.observer.AbstractObserver;

/**
 * @author henengqiang
 * @date 2018/11/2
 */
public class HexObserver extends AbstractObserver {

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()));
    }

}
