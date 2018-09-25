package com.hnq.study.facadepattern.service.impl;

import com.hnq.study.facadepattern.service.IShape;

/**
 * @author henengqiang
 * @date 2018/9/25
 */
public class Square implements IShape {

    @Override
    public void draw() {
        for (int i = 0; i < 15; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print("*");
            for (int j = 0; j < 13; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for (int i = 0; i < 15; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

}
