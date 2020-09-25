package com.hnq.study.decoratorpattern.headfirstdemo.service.decorators;

import com.hnq.study.decoratorpattern.headfirstdemo.service.Beverage;
import com.hnq.study.decoratorpattern.headfirstdemo.service.CondimentDecorator;

/**
 * 奶泡装饰
 *
 * @author henengqiang
 * @date 2020/09/25
 */
public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage) {
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
