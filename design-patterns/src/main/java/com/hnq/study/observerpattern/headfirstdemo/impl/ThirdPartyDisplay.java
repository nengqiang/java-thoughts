package com.hnq.study.observerpattern.headfirstdemo.impl;

import com.hnq.study.observerpattern.headfirstdemo.DisplayElement;
import com.hnq.study.observerpattern.headfirstdemo.Observer;

/**
 * @author henengqiang
 * @date 2020/8/3
 */
public class ThirdPartyDisplay implements Observer, DisplayElement {

    @Override
    public void update(float temperature, float humidity, float pressure) {

    }

    @Override
    public void display() {

    }
}
