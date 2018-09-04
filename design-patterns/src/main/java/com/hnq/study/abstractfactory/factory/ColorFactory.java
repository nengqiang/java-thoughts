package com.hnq.study.abstractfactory.factory;

import com.hnq.study.abstractfactory.service.Color;
import com.hnq.study.abstractfactory.service.Shape;
import com.hnq.study.abstractfactory.service.impl.Blue;
import com.hnq.study.abstractfactory.service.impl.Green;
import com.hnq.study.abstractfactory.service.impl.Red;

/**
 * 创建扩展了 AbstractFactory 的工厂类，基于给定的信息生成实体类的对象。
 *
 * @author henengqiang
 * @date 2018/9/4
 */
public class ColorFactory extends AbstractFactory {

    private static final String RED = "red";

    private static final String GREEN = "green";

    private static final String BLUE = "blue";

    /**
     * 使用 getColor 方法获取颜色颜色的颜色
     * @param color 颜色颜色
     * @return      颜色颜色的颜色
     */
    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (RED.equals(color)) {
            return new Red();
        } else if (GREEN.equals(color)) {
            return new Green();
        } else if (BLUE.equals(color)) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }

}
