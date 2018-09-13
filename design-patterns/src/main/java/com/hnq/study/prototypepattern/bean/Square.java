package com.hnq.study.prototypepattern.bean;

import com.hnq.study.prototypepattern.father.AbstractShape;

/**
 * @author henengqiang
 * @date 2018/9/13
 */
public class Square extends AbstractShape {

    public Square() {
        type = "Square";
    }

    @Override
    protected void draw() {
        System.out.println("Inside Square::draw() method.");
    }

}
