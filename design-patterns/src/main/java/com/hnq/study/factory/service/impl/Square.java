package com.hnq.study.factory.service.impl;

import com.hnq.study.factory.service.IShape;

/**
 * @author henengqiang
 * @date 2018/8/28
 */
public class Square implements IShape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }

}
