package com.hnq.study.decoratorpattern.headfirstdemo.service.beverages;

import com.hnq.study.decoratorpattern.headfirstdemo.service.Beverage;

/**
 * @author henengqiang
 * @date 2020/09/25
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
