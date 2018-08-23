package com.hnq.study.strategy.anexample.service.impl;

import com.hnq.study.strategy.anexample.service.ICalPrice;

/**
 * @author henengqiang
 * @date 2018/8/20
 */
public class Normal implements ICalPrice {

    @Override
    public Double calPrice(Double originPrice) {
        return originPrice;
    }

}
