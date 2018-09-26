package com.hnq.study.flyweightpattern;

import com.hnq.study.flyweightpattern.factory.ShapeFactory;
import com.hnq.study.flyweightpattern.service.impl.Circle;

/**
 * 创建一个 IShape 接口和实现了 IShape 接口的实体类 Circle。下一步是定义工厂类 ShapeFactory。
 *  ShapeFactory 有一个 Circle 的 HashMap，其中键名为 Circle 对象的颜色。无论何时接收到请求，都会创建一个特定颜色的圆。
 * ShapeFactory 检查它的 HashMap 中的 circle 对象，如果找到 Circle 对象，则返回该对象，否则将创建一个存储在 HashMap 中以备
 * 后续使用的新对象，并把该对象返回到客户端。
 * FlyWeightPatternDemo，演示类使用 ShapeFactory 来获取 IShape 对象。它将向 ShapeFactory 传递信息
 * （red / green / blue/ black / white），以便获取它所需对象的颜色。
 *
 * @author henengqiang
 * @date 2018/9/26
 */
public class FlyweightPatternDemo {

    private static final String[] COLORS = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        drawCircle();
    }

    private static void drawCircle() {
        for (int i = 0; i < 20; i++) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setRadius(5);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return COLORS[(int)(Math.random() * COLORS.length)];
    }

}
