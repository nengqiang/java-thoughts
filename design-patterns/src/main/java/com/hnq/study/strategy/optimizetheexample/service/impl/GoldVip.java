package com.hnq.study.strategy.optimizetheexample.service.impl;

import com.hnq.study.strategy.optimizetheexample.service.ICalPrice;
import com.hnq.study.strategy.optimizetheexample.service.PriceRegion;

/**
 * @author henengqiang
 * @date 2018/8/21
 */
@PriceRegion(min = 30000)
public class GoldVip implements ICalPrice {

    @Override
    public Double calPrice(Double originPrice) {
        return originPrice * 0.7;
    }

}
