package com.hnq.study.strategy.anexample.bean;

import com.hnq.study.strategy.anexample.service.ICalPrice;
import com.hnq.study.strategy.anexample.service.impl.GoldVip;
import com.hnq.study.strategy.anexample.service.impl.Normal;
import com.hnq.study.strategy.anexample.service.impl.SuperVip;
import com.hnq.study.strategy.anexample.service.impl.Vip;

/**
 * 客户类，需要客户类帮我们完成玩家升级的功能。
 * @author henengqiang
 * @date 2018/8/20
 */
public class Player {

    /**
     * 客户消费总额达30000升为黄金VIP
     */
    private static final Integer GOLD_VIP = 30000;

    /**
     * 客户消费总额达20000升为超级VIP
     */
    private static final Integer SUPER_VIP = 20000;

    /**
     * 客户消费总额达10000升为VIP
     */
    private static final Integer VIP = 10000;

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

    /**
     * 客户购买皮肤，就会增加他的总额
     * @param amount    单次消费总额
     */
    public void buy(Double amount) {
        this.amount = amount;
        totalAmount += amount;
        if (totalAmount >= GOLD_VIP) {
            calPrice = new GoldVip();
        } else if (totalAmount >= SUPER_VIP) {
            calPrice = new SuperVip();
        } else if (totalAmount >= VIP) {
            calPrice = new Vip();
        }
    }

    /**
     * 计算客户最终要付的钱
     * @return  最终要付的钱
     */
    public Double calLastAmount() {
        return calPrice.calPrice(amount);
    }

}
