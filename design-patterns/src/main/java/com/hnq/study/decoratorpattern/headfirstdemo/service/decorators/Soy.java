package com.hnq.study.decoratorpattern.headfirstdemo.service.decorators;

import com.hnq.study.decoratorpattern.headfirstdemo.service.Beverage;
import com.hnq.study.decoratorpattern.headfirstdemo.service.CondimentDecorator;

/**
 * 大豆装饰
 *
 * @author henengqiang
 * @date 2020/09/25
 */
public class Soy extends CondimentDecorator {

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return .30 + beverage.cost();
    }

}
