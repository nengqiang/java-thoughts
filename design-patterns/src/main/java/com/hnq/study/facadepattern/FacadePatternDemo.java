package com.hnq.study.facadepattern;

import com.hnq.study.facadepattern.service.ShapeMaker;

/**
 * 创建一个 IShape 接口和实现了 IShape 接口的实体类。下一步是定义一个外观类 ShapeMaker。
 * ShapeMaker 类使用实体类来代表用户对这些类的调用。FacadePatternDemo，我们的演示类使用 ShapeMaker 类来显示结果。
 *
 * @author henengqiang
 * @date 2018/9/25
 */
public class FacadePatternDemo {

    public static void main(String[] args) {
        drawShape();
    }

    private static void drawShape() {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }

}
