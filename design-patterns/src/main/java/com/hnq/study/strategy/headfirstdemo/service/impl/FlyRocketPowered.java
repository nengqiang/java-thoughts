package com.hnq.study.strategy.headfirstdemo.service.impl;

import com.hnq.study.strategy.headfirstdemo.service.FlyBehavior;

/**
 * @author henengqiang
 * @date 2020/8/1
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
