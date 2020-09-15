package com.hnq.study.strategy.headfirstdemo.service.impl;

import com.hnq.study.strategy.headfirstdemo.service.QuackBehavior;

/**
 * 橡皮鸭子吱吱叫
 *
 * @author henengqiang
 * @date 2020/8/1
 */
public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeak");
    }

}
