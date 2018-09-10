package com.hnq.study.builderpattern.bean;

import com.hnq.study.builderpattern.service.impl.AbstractBurger;

/**
 * @author henengqiang
 * @date 2018/9/10
 */
public class ChickenBurger extends AbstractBurger {

    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5F;
    }

}
