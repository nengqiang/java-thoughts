package com.hnq.study.strategy.headfirstdemo;

import com.hnq.study.strategy.headfirstdemo.service.FlyBehavior;
import com.hnq.study.strategy.headfirstdemo.service.QuackBehavior;

/**
 * @author henengqiang
 * @date 2020/8/1
 */
public abstract class BaseDuck {

    protected QuackBehavior quackBehavior;

    protected FlyBehavior flyBehavior;

    public BaseDuck() {
    }

    public abstract void display();

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

}
