package com.hnq.study.strategy.optimizetheexample.service.impl;

import com.hnq.study.strategy.optimizetheexample.service.ICalPrice;
import com.hnq.study.strategy.optimizetheexample.service.PriceRegion;

/**
 * @author henengqiang
 * @date 2018/8/21
 */
@PriceRegion(max = 20000)
public class Vip implements ICalPrice {

    @Override
    public Double calPrice(Double originPrice) {
        return originPrice * 0.9;
    }

}
