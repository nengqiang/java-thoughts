package com.hnq.study.decoratorpattern.service;

/**
 * @author henengqiang
 * @date 2018/9/25
 */
public class RedShapeDecorator extends AbstractShapeDecorator {

    public RedShapeDecorator(IShape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(IShape decoratedShape) {
        System.out.println("Border Color: Red");
    }

}
