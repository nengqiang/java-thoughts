package com.hnq.study.factory.factory;

import com.hnq.study.factory.service.IShape;
import com.hnq.study.factory.service.impl.Circle;
import com.hnq.study.factory.service.impl.Rectangle;
import com.hnq.study.factory.service.impl.Square;

/**
 * 创建一个工厂，生成基于给定信息的实体类的对象。
 *
 * @author henengqiang
 * @date 2018/8/28
 */
public class ShapeFactory {

    private static final String CIRCLE = "circle";

    private static final String RECTANGLE = "rectangle";

    private static final String SQUARE = "square";

    /**
     * 使用 getShape 方法获取形状类型的对象
     * @param shapeType 形状类型
     * @return          形状类型的对象
     */
    public IShape getShape(String shapeType) {
        if (shapeType == null || "".equals(shapeType)) {
            return null;
        }
        if (CIRCLE.equals(shapeType)) {
            return new Circle();
        } else if (RECTANGLE.equals(shapeType)) {
            return new Rectangle();
        } else if (SQUARE.equals(shapeType)) {
            return new Square();
        }
        return null;
    }

}
