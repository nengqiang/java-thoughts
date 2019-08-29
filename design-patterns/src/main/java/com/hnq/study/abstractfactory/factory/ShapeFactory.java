package com.hnq.study.abstractfactory.factory;

import com.hnq.study.abstractfactory.service.Color;
import com.hnq.study.abstractfactory.service.Shape;
import com.hnq.study.abstractfactory.service.impl.Circle;
import com.hnq.study.abstractfactory.service.impl.Rectangle;
import com.hnq.study.abstractfactory.service.impl.Square;

/**
 * 创建扩展了 AbstractFactory 的工厂类，基于给定的信息生成实体类的对象。
 *
 * @author henengqiang
 * @date 2018/9/4
 */
public class ShapeFactory extends AbstractFactory {

    private static final String CIRCLE = "circle";

    private static final String RECTANGLE = "rectangle";

    private static final String SQUARE = "square";

    @Override
    public Color getColor(String color) {
        return null;
    }

    /**
     * 使用 getShape 方法获取形状类型的对象
     * @param shapeType 形状类型
     * @return          形状类型的对象
     */
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null || "".equals(shapeType)) {
            return null;
        }
        switch (shapeType) {
            case CIRCLE:
                return new Circle();
            case RECTANGLE:
                return new Rectangle();
            case SQUARE:
                return new Square();
                default: return null;
        }
    }

}
