package com.hnq.study.factory;

import com.hnq.study.factory.factory.ShapeFactory;
import com.hnq.study.factory.service.Shape;

/**
 * @author henengqiang
 * @date 2018/8/28
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("circle");
        Shape shape2 = shapeFactory.getShape("rectangle");
        Shape shape3 = shapeFactory.getShape("square");
        Shape shape4 = shapeFactory.getShape("");

        if (shape1 != null) {
            shape1.draw();
        } else {
            noShape();
        }

        if (shape2 != null) {
            shape2.draw();
        } else {
            noShape();
        }

        if (shape3 != null) {
            shape3.draw();
        } else {
            noShape();
        }

        if (shape4 != null) {
            shape4.draw();
        } else {
            noShape();
        }

    }

    private static void noShape() {
        System.out.println("没有这种形状");
    }

}
