package com.hnq.study.strategy.headfirstdemo;

import com.hnq.study.strategy.headfirstdemo.service.impl.FlyWithWings;
import com.hnq.study.strategy.headfirstdemo.service.impl.Quack;

/**
 * @author henengqiang
 * @date 2020/8/1
 */
public class MallardDuck extends BaseDuck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
