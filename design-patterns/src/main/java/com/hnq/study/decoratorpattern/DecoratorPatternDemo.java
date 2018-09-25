package com.hnq.study.decoratorpattern;

import com.hnq.study.decoratorpattern.service.IShape;
import com.hnq.study.decoratorpattern.service.RedShapeDecorator;
import com.hnq.study.decoratorpattern.service.impl.Circle;
import com.hnq.study.decoratorpattern.service.impl.Rectangle;

/**
 *  创建一个 IShape 接口和实现了 Shape 接口的实体类。然后我们创建一个实现了 IShape 接口的抽象装饰类 AbstractShapeDecorator，
 * 并把 IShape 对象作为它的实例变量。
 * RedShapeDecoratorImpl 是实现了 AbstractShapeDecorator 的实体类。
 * DecoratorPatternDemo，我们的演示类使用 RedShapeDecoratorImpl 来装饰 IShape 对象。
 *
 * @author henengqiang
 * @date 2018/9/25
 */
public class DecoratorPatternDemo {

    public static void main(String[] args) {
        drawShape();
    }

    private static void drawShape() {
        IShape circle = new Circle();
        IShape redCircle = new RedShapeDecorator(new Circle());
        IShape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border: ");
        circle.draw();

        System.out.println("Circle of red border: ");
        redCircle.draw();

        System.out.println("Rectangle of red border: ");
        redRectangle.draw();
    }


}
