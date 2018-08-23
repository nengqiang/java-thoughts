package com.hnq.study.strategy.optimizetheexample.bean;

import com.hnq.study.strategy.optimizetheexample.factory.CalPriceFactory;
import com.hnq.study.strategy.optimizetheexample.service.ICalPrice;
import com.hnq.study.strategy.optimizetheexample.service.impl.Normal;

/**
 * @author henengqiang
 * @date 2018/8/21
 */
public class Player {

    /**
     * 客户消费总额
     */
    private Double totalAmount = 0D;

    /**
     * 客户单次消费金额
     */
    private Double amount = 0D;

    /**
     * 每个客户都有一个计算价格的策略，初始都是普通计算，即原价
     */
    private ICalPrice calPrice = new Normal();

    private CalPriceFactory calPriceFactory = CalPriceFactory.getInstance();

    /**
     * 客户购买皮肤，就会增加他的总额
     * @param amount    单次消费总额
     */
    public void buy(Double amount) {
        this.amount = amount;
        totalAmount += amount;
        // 变化点，将策略的制定转移给了策略工厂，将这部分责任分离出去
        calPrice = calPriceFactory.createCalPrice(this);
    }

    /**
     * 计算客户最终要付的钱
     * @return  最终要付的钱
     */
    public Double calLastAmount() {
        return calPrice.calPrice(amount);
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

}
