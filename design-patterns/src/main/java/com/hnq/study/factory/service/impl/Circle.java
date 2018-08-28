package com.hnq.study.factory.service.impl;

import com.hnq.study.factory.service.Shape;

/**
 * @author henengqiang
 * @date 2018/8/28
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

}
