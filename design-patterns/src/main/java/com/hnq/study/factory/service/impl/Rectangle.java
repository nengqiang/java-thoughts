package com.hnq.study.factory.service.impl;

import com.hnq.study.factory.service.IShape;

/**
 * @author henengqiang
 * @date 2018/8/28
 */
public class Rectangle implements IShape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }

}
