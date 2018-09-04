package com.hnq.study.abstractfactory.service.impl;

import com.hnq.study.abstractfactory.service.Color;

/**
 * @author henengqiang
 * @date 2018/9/4
 */
public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Blue's fill() method.");
    }

}
