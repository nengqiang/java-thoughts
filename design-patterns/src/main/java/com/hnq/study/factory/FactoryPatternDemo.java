package com.hnq.study.factory;

import com.hnq.study.factory.factory.ShapeFactory;
import com.hnq.study.factory.service.IShape;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        shapes.stream().filter(Objects::nonNull).forEach(IShape::draw);

    }

}
