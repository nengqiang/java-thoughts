package com.hnq.study.observerpattern.headfirstdemo;

/**
 * @author henengqiang
 * @date 2020/8/3
 */
public interface Subject {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();

}
