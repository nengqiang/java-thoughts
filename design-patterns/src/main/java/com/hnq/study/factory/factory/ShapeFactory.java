package com.hnq.study.factory.factory;

import com.hnq.study.factory.service.IShape;
import com.hnq.study.factory.service.impl.Circle;
import com.hnq.study.factory.service.impl.Rectangle;
import com.hnq.study.factory.service.impl.Square;
import org.apache.commons.lang3.StringUtils;

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
     *
     * @param shapeType 形状类型
     * @return          形状类型的对象
     */
    public IShape getShape(String shapeType) {
        if (StringUtils.isEmpty(shapeType)) {
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
