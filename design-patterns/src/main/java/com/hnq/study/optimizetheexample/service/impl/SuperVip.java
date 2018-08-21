package com.hnq.study.optimizetheexample.service.impl;

import com.hnq.study.optimizetheexample.service.ICalPrice;
import com.hnq.study.optimizetheexample.service.PriceRegion;

/**
 * @author henengqiang
 * @date 2018/8/21
 */
@PriceRegion(min = 20000, max = 30000)
public class SuperVip implements ICalPrice {

    @Override
    public Double calPrice(Double originPrice) {
        return originPrice * 0.8;
    }

}
