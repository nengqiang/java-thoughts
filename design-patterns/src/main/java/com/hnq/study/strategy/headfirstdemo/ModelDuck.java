package com.hnq.study.strategy.headfirstdemo;

import com.hnq.study.strategy.headfirstdemo.service.impl.FlyNoWay;
import com.hnq.study.strategy.headfirstdemo.service.impl.Quack;

/**
 * @author henengqiang
 * @date 2020/8/1
 */
public class ModelDuck extends BaseDuck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
