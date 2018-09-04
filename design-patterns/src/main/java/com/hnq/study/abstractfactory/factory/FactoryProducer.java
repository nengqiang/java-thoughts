package com.hnq.study.abstractfactory.factory;

/**
 * 创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
 *
 * @author henengqiang
 * @date 2018/9/4
 */
public class FactoryProducer {

    private static final String SHAPE = "shape";

    private static final String COLOR = "color";

    public static AbstractFactory getFactory(String choice) {
        if (SHAPE.equals(choice)) {
            return new ShapeFactory();
        } else if (COLOR.equals(choice)) {
            return new ColorFactory();
        }
        return null;
    }

}
