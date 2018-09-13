package com.hnq.study.prototypepattern.bean;

import com.hnq.study.prototypepattern.father.AbstractShape;

/**
 * @author henengqiang
 * @date 2018/9/13
 */
public class Rectangle extends AbstractShape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }

}
