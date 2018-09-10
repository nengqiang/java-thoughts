package com.hnq.study.builderpattern.bean;

import com.hnq.study.builderpattern.service.impl.AbstractBurger;

/**
 * @author henengqiang
 * @date 2018/9/10
 */
public class VegBurger extends AbstractBurger {

    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0F;
    }

}
