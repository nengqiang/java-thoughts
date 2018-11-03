package com.hnq.study.observerpattern.observer.entity;

import com.google.common.collect.Lists;
import com.hnq.study.observerpattern.observer.AbstractObserver;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/11/2
 */
public class Subject {

    private List<AbstractObserver> observers = Lists.newArrayList();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(AbstractObserver observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        observers.forEach(AbstractObserver::update);
    }

}
