package com.hnq.study.strategy.headfirstdemo.service.impl;

import com.hnq.study.strategy.headfirstdemo.service.FlyBehavior;

/**
 * @author henengqiang
 * @date 2020/8/1
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
