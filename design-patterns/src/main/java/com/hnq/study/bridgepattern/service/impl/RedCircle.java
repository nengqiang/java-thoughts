package com.hnq.study.bridgepattern.service.impl;

import com.hnq.study.bridgepattern.service.IDraw;

/**
 * 实心圆
 *
 * @author henengqiang
 * @date 2018/9/19
 */
public class RedCircle implements IDraw {

    @Override
    public void drawCircle(int radius, int pointX, int pointY) {
        System.out.println("Color: red");
        for (int k = 0; k <= 2 * radius; k += 2) {
            int x = (int) Math.round(radius - Math.sqrt(radius * radius - (radius - k) * (radius - k)));
            int l = 2 * (radius - x);
            for (int i = 0; i <= x; i++) {
                System.out.print(" ");
            }
            System.out.print(".");
            for (int i = 0; i <= l; i++) {
                System.out.print("*");
            }
            System.out.println("*");
        }
    }

}
