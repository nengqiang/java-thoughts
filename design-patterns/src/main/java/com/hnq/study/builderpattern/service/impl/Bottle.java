package com.hnq.study.builderpattern.service.impl;

import com.hnq.study.builderpattern.service.Packing;

/**
 * @author henengqiang
 * @date 2018/9/10
 */
public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle's pack()";
    }

}
