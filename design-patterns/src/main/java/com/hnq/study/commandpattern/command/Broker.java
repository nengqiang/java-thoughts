package com.hnq.study.commandpattern.command;

import com.hnq.study.commandpattern.service.IOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令调用类
 *
 * @author henengqiang
 * @date 2018/9/27
 */
public class Broker {

    private List<IOrder> orderList = new ArrayList<>();

    public void takeOrder(IOrder order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (IOrder order : orderList) {
            order.execute();
        }
        orderList.clear();
    }

}
