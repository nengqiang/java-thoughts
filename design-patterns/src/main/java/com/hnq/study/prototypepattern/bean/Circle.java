package com.hnq.study.prototypepattern.bean;

import com.hnq.study.prototypepattern.father.AbstractShape;

/**
 * @author henengqiang
 * @date 2018/9/13
 */
public class Circle extends AbstractShape {

    public Circle() {
        type = "Circle";
    }

    @Override
    protected void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

}
