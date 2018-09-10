package com.hnq.study.builderpattern.service.impl;

import com.hnq.study.builderpattern.service.Item;
import com.hnq.study.builderpattern.service.Packing;

/**
 * @author henengqiang
 * @date 2018/9/10
 */
public abstract class AbstractColdDrink implements Item {

    @Override
    public abstract String name();

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();

}
