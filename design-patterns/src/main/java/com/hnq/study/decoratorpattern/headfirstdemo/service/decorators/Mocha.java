package com.hnq.study.decoratorpattern.headfirstdemo.service.decorators;

import com.hnq.study.decoratorpattern.headfirstdemo.service.Beverage;
import com.hnq.study.decoratorpattern.headfirstdemo.service.CondimentDecorator;

/**
 * 摩卡装饰
 *
 * @author henengqiang
 * @date 2020/09/25
 */
public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }

}
