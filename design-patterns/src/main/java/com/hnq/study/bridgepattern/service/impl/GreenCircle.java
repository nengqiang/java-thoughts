package com.hnq.study.bridgepattern.service.impl;

import com.hnq.study.bridgepattern.service.IDraw;

/**
 * @author henengqiang
 * @date 2018/9/19
 */
public class GreenCircle implements IDraw {

    @Override
    public void drawCircle(int radius, int pointX, int pointY) {
        System.out.println("Color: green");
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
