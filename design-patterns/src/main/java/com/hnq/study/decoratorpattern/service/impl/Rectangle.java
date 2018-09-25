package com.hnq.study.decoratorpattern.service.impl;

import com.hnq.study.decoratorpattern.service.IShape;

/**
 * @author henengqiang
 * @date 2018/9/25
 */
public class Rectangle implements IShape {

    @Override
    public void draw() {
        for (int i = 0; i < 20; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print("*");
            for (int j = 0; j < 18; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for (int i = 0; i < 20; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

}
