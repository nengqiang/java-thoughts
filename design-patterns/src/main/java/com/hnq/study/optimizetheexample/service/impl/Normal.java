package com.hnq.study.optimizetheexample.service.impl;

import com.hnq.study.optimizetheexample.service.ICalPrice;
import com.hnq.study.optimizetheexample.service.PriceRegion;

/**
 * @author henengqiang
 * @date 2018/8/21
 */
@PriceRegion(max = 10000)
public class Normal implements ICalPrice {

    @Override
    public Double calPrice(Double originPrice) {
        return originPrice;
    }

}
