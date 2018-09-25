package com.hnq.study.facadepattern.service;

import com.hnq.study.facadepattern.service.impl.Circle;
import com.hnq.study.facadepattern.service.impl.Rectangle;
import com.hnq.study.facadepattern.service.impl.Square;

/**
 * @author henengqiang
 * @date 2018/9/25
 */
public class ShapeMaker {

    private IShape circle;

    private IShape rectangle;

    private IShape square;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }

}
