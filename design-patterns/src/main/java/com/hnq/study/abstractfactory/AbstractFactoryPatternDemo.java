package com.hnq.study.abstractfactory;

import com.hnq.study.abstractfactory.factory.AbstractFactory;
import com.hnq.study.abstractfactory.factory.FactoryProducer;
import com.hnq.study.abstractfactory.service.Color;
import com.hnq.study.abstractfactory.service.Shape;

/**
 * 使用 FactoryProducer 来获取 AbstractFactory，通过传递类型信息来获取实体类的对象。
 *
 * @author henengqiang
 * @date 2018/9/4
 */
public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");

        if (shapeFactory != null) {
            //获取形状为 Circle 的对象
            Shape shape1 = shapeFactory.getShape("circle");

            //调用 Circle 的 draw 方法
            if (shape1 != null) {
                shape1.draw();
            } else {
                noShape();
            }

            //获取形状为 Rectangle 的对象
            Shape shape2 = shapeFactory.getShape("rectangle");

            //调用 Rectangle 的 draw 方法
            if (shape2 != null) {
                shape2.draw();
            } else {
                noShape();
            }

            //获取形状为 Square 的对象
            Shape shape3 = shapeFactory.getShape("Square");

            //调用 Square 的 draw 方法
            if (shape3 != null) {
                shape3.draw();
            } else {
                noShape();
            }
        } else {
            noFactory();
        }

        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");

        if (colorFactory != null) {
            //获取颜色为 Red 的对象
            Color color1 = colorFactory.getColor("red");

            //调用 Red 的 fill 方法
            if (color1 != null) {
                color1.fill();
            } else {
                noColor();
            }

            //获取颜色为 Green 的对象
            Color color2 = colorFactory.getColor("Green");

            //调用 Green 的 fill 方法
            if (color2 != null) {
                color2.fill();
            } else {
                noColor();
            }

            //获取颜色为 Blue 的对象
            Color color3 = colorFactory.getColor("blue");

            //调用 Blue 的 fill 方法
            if (color3 != null) {
                color3.fill();
            } else {
                noColor();
            }
        } else {
            noFactory();
        }

        AbstractFactory factory = FactoryProducer.getFactory("");

        if (factory != null) {
            factory.getColor("");
            factory.getShape("");
        } else {
            noFactory();
        }
    }

    private static void noFactory() {
        System.out.println("没有获取到工厂");
    }

    private static void noShape() {
        System.out.println("没有这种形状");
    }

    private static void noColor() {
        System.out.println("没有这种颜色");
    }

}
