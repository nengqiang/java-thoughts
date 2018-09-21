package com.hnq.study.bridgepattern.service;

/**
 * @author henengqiang
 * @date 2018/9/19
 */
public class Circle extends AbstractShape {

    private int x, y, radius;

    public Circle(IDraw draw, int x, int y, int radius) {
        super(draw);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        draw.drawCircle(radius, x, y);
    }

}
