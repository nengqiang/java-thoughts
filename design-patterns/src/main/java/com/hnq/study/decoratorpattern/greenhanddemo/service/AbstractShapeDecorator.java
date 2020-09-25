package com.hnq.study.decoratorpattern.greenhanddemo.service;

/**
 * @author henengqiang
 * @date 2018/9/25
 */
public abstract class AbstractShapeDecorator implements IShape {

    protected IShape decoratedShape;

    public AbstractShapeDecorator(IShape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }

}
