package com.hnq.study.anexample.service.impl;

import com.hnq.study.anexample.service.ICalPrice;

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
