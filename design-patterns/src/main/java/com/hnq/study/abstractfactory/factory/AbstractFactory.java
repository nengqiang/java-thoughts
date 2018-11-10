package com.hnq.study.abstractfactory.factory;

import com.hnq.study.abstractfactory.service.Color;
import com.hnq.study.abstractfactory.service.Shape;

/**
 * 为 Color 和 IShape 对象创建抽象类来获取工厂。
 *
 * @author henengqiang
 * @date 2018/9/4
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);

}
