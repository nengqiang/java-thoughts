package com.hnq.study.builderpattern.bean;

import com.hnq.study.builderpattern.service.impl.AbstractColdDrink;

/**
 * @author henengqiang
 * @date 2018/9/10
 */
public class Coke extends AbstractColdDrink {

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0F;
    }

}
