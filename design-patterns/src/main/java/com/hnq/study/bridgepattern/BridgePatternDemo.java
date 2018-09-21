package com.hnq.study.bridgepattern;

import com.hnq.study.bridgepattern.service.AbstractShape;
import com.hnq.study.bridgepattern.service.Circle;
import com.hnq.study.bridgepattern.service.impl.GreenCircle;
import com.hnq.study.bridgepattern.service.impl.RedCircle;

/**
 *  有一个作为桥接实现的 IDraw 接口和实现了 IDraw 接口的实体类 RedCircle、GreenCircle。AbstractShape 是一个抽象类，
 * 将使用 IDraw 的对象。BridgePatternDemo，我们的演示类使用 AbstractShape 类来画出不同颜色的圆。
 *
 * @author henengqiang
 * @date 2018/9/19
 */
public class BridgePatternDemo {

    public static void main(String[] args) {
        drawCircle();
    }

    private static void drawCircle() {
        AbstractShape redCircle = new Circle(new RedCircle(),0, 0, 10 );
        AbstractShape greenCircle = new Circle(new GreenCircle(), 0, 0, 10);
        redCircle.draw();
        greenCircle.draw();
    }

}
