package com.hnq.study.bridgepattern.service;

/**
 * @author henengqiang
 * @date 2018/9/19
 */
public abstract class AbstractShape {

    protected IDraw draw;

    protected  AbstractShape(IDraw draw) {
        this.draw = draw;
    }

    public abstract void draw();

}
