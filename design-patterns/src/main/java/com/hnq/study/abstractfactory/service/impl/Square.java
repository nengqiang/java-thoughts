package com.hnq.study.abstractfactory.service.impl;

import com.hnq.study.abstractfactory.service.Shape;

/**
 * @author henengqiang
 * @date 2018/9/4
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square's draw() method.");
    }

}
