package com.hnq.study.prototypepattern;

import com.hnq.study.prototypepattern.cache.ShapeCache;
import com.hnq.study.prototypepattern.father.AbstractShape;

/**
 *  创建一个抽象类 Shape 和扩展了 Shape 类的实体类。下一步是定义类 ShapeCache，
 * 该类把 shape 对象存储在一个 Hashtable 中，并在请求的时候返回它们的克隆。
 *
 * PrototypePatternDemo，演示类使用 ShapeCache 类来获取 Shape 对象。
 *
 * @author henengqiang
 * @date 2018/9/13
 */
public class PrototypePatternDemo {

    public static void main(String[] args) {
        getShape();
    }

    private static void getShape() {
        ShapeCache.loadCache();

        AbstractShape clonedShape = ShapeCache.getShape("1");
        System.out.println("Shape: " + clonedShape.getType());

        AbstractShape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape: " + clonedShape2.getType());

        AbstractShape clonedShape3 = ShapeCache.getShape("3");
        System.out.println("Shape: " + clonedShape3.getType());
    }

}
