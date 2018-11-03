package com.hnq.study.observerpattern.observer;

import com.hnq.study.observerpattern.observer.entity.Subject;

/**
 * @author henengqiang
 * @date 2018/11/2
 */
public abstract class AbstractObserver {

    protected Subject subject;

    public abstract void update();

}
