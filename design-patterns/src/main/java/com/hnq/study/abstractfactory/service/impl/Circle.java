package com.hnq.study.abstractfactory.service.impl;

import com.hnq.study.abstractfactory.service.Shape;

/**
 * @author henengqiang
 * @date 2018/9/4
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle's draw() method.");
    }

}
