package com.hnq.study.flyweightpattern.service.impl;

import com.hnq.study.flyweightpattern.service.IShape;

/**
 * @author henengqiang
 * @date 2018/9/26
 */
public class Circle implements IShape {

    private String color;

    private int radius;

    public Circle() {
    }

    public Circle(String color) {
        this.color = color;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Color: " + color);
        for (int y = 0; y <= 2 * radius; y += 2) {
            int x = (int) Math.round(radius - Math.sqrt(radius * radius - (radius - y) * (radius - y)));
            int l = 2 * (radius - x);
            for (int i = 0; i <= x; i++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int i = 0; i <= l; i++) {
                if (i < l) {
                    System.out.print(" ");
                } else {
                    System.out.println("*");
                }
            }
        }
    }

}
