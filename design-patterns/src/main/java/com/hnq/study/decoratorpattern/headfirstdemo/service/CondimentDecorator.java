package com.hnq.study.decoratorpattern.headfirstdemo.service;

/**
 * 调料<br>
 * 抽象装饰者
 *
 * @author henengqiang
 * @date 2020/09/25
 */
public abstract class CondimentDecorator extends Beverage {

    @Override
    public abstract String getDescription();

}
