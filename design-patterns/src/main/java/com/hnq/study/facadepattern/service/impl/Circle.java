package com.hnq.study.facadepattern.service.impl;

import com.hnq.study.facadepattern.service.IShape;

/**
 * @author henengqiang
 * @date 2018/9/25
 */
public class Circle implements IShape {

    @Override
    public void draw() {
        int radius = 10;
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
