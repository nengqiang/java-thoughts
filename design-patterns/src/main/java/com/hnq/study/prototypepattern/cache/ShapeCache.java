package com.hnq.study.prototypepattern.cache;

import com.hnq.study.prototypepattern.bean.Circle;
import com.hnq.study.prototypepattern.bean.Rectangle;
import com.hnq.study.prototypepattern.bean.Square;
import com.hnq.study.prototypepattern.father.AbstractShape;

import java.util.Hashtable;

/**
 * 创建一个类，从数据库获取实体类，并把它们存储在一个 Hashtable 中。
 *
 * @author henengqiang
 * @date 2018/9/13
 */
public class ShapeCache {

    private static Hashtable<String, AbstractShape> shapeMap = new Hashtable<>();

    public static AbstractShape getShape(String shapeId) {
        AbstractShape cachedShape = shapeMap.get(shapeId);
        return (AbstractShape) cachedShape.clone();
    }

    /**
     * 对每种情况都进行数据库查询，并创建该形状
     */
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }

}
