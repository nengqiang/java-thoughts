package com.hnq.study.flyweightpattern.factory;

import com.hnq.study.flyweightpattern.service.IShape;
import com.hnq.study.flyweightpattern.service.impl.Circle;

import java.util.HashMap;

/**
 * @author henengqiang
 * @date 2018/9/26
 */
public class ShapeFactory {

    private static final HashMap<String, IShape> CIRCLE_MAP = new HashMap<>();

    public static IShape getCircle(String color) {
        Circle circle = (Circle) CIRCLE_MAP.get(color);
        if (circle == null) {
            circle = new Circle(color);
            CIRCLE_MAP.put(color, circle);
            System.out.println("Creating circle of color: " + color);
        }
        return circle;
    }

}
