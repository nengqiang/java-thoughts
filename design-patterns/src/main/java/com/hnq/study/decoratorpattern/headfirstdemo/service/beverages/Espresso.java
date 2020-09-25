package com.hnq.study.decoratorpattern.headfirstdemo.service.beverages;

import com.hnq.study.decoratorpattern.headfirstdemo.service.Beverage;

/**
 * @author henengqiang
 * @date 2020/09/25
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
