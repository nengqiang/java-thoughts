package com.hnq.study.strategy.headfirstdemo.service.impl;

import com.hnq.study.strategy.headfirstdemo.service.QuackBehavior;

/**
 * @author henengqiang
 * @date 2020/8/1
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
