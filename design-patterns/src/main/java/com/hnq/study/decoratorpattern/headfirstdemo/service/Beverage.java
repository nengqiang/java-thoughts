package com.hnq.study.decoratorpattern.headfirstdemo.service;

/**
 * 饮料
 *
 * @author henengqiang
 * @date 2020/09/25
 */
public abstract class Beverage {

    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
