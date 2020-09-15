package com.hnq.study.strategy.headfirstdemo;

import com.hnq.study.strategy.headfirstdemo.service.impl.FlyRocketPowered;

/**
 * @author henengqiang
 * @date 2020/8/1
 */
public class MiniDuckSimulator {

    public static void main(String[] args) {
        duck2();
    }

    private static void duck1() {
        BaseDuck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();
        mallard.display();
    }

    private static void duck2() {
        BaseDuck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
        model.performQuack();
        model.display();
        model.swim();
    }
}
