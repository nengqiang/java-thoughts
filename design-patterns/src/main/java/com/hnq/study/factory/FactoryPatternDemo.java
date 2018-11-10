package com.hnq.study.factory;

import com.hnq.study.factory.factory.ShapeFactory;
import com.hnq.study.factory.service.IShape;

import java.util.Arrays;
import java.util.List;

/**
 * @author henengqiang
 * @date 2018/8/28
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        IShape shape1 = shapeFactory.getShape("circle");
        IShape shape2 = shapeFactory.getShape("rectangle");
        IShape shape3 = shapeFactory.getShape("square");
        IShape shape4 = shapeFactory.getShape("");

        List<IShape> shapes = Arrays.asList(shape1, shape2, shape3, shape4);

        shapes.forEach(shape -> {
            if (shape != null) {
                shape.draw();
            } else {
                noShape();
            }
        });

    }

    private static void noShape() {
        System.out.println("没有这种形状");
    }

}
