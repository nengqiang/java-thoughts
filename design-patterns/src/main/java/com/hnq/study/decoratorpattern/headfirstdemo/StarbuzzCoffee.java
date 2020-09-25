package com.hnq.study.decoratorpattern.headfirstdemo;

import com.hnq.study.decoratorpattern.headfirstdemo.service.Beverage;
import com.hnq.study.decoratorpattern.headfirstdemo.service.beverages.DarkRoast;
import com.hnq.study.decoratorpattern.headfirstdemo.service.beverages.Espresso;
import com.hnq.study.decoratorpattern.headfirstdemo.service.beverages.HouseBlend;
import com.hnq.study.decoratorpattern.headfirstdemo.service.decorators.Mocha;
import com.hnq.study.decoratorpattern.headfirstdemo.service.decorators.Soy;
import com.hnq.study.decoratorpattern.headfirstdemo.service.decorators.Whip;

/**
 * @author henengqiang
 * @date 2020/09/25
 */
public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() +" $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }

}
