package com.hnq.study.builderpattern.bean;

import com.hnq.study.builderpattern.service.impl.AbstractColdDrink;

/**
 * @author henengqiang
 * @date 2018/9/10
 */
public class Pepsi extends AbstractColdDrink {

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0F;
    }

}
