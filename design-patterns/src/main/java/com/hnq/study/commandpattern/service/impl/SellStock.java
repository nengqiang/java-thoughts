package com.hnq.study.commandpattern.service.impl;

import com.hnq.study.commandpattern.bean.Stock;
import com.hnq.study.commandpattern.service.IOrder;

/**
 * @author henengqiang
 * @date 2018/9/27
 */
public class SellStock implements IOrder {

    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }

}
