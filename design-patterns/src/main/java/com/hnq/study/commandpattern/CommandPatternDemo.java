package com.hnq.study.commandpattern;

import com.hnq.study.commandpattern.bean.Stock;
import com.hnq.study.commandpattern.command.Broker;
import com.hnq.study.commandpattern.service.impl.BuyStock;
import com.hnq.study.commandpattern.service.impl.SellStock;

/**
 *  首先创建作为命令的接口 IOrder，然后创建作为请求的 Stock 类。实体命令类 BuyStock 和 SellStock，实现了 IOrder 接口，
 * 将执行实际的命令处理。创建作为调用对象的类 Broker，它接受订单并能下订单。
 * Broker 对象使用命令模式，基于命令的类型确定哪个对象执行哪个命令。CommandPatternDemo，演示类使用 Broker 类来演示命令模式
 *
 * @author henengqiang
 * @date 2018/9/27
 */
public class CommandPatternDemo {

    public static void main(String[] args) {
        placeOrder();
    }

    private static void placeOrder() {
        Stock stock = new Stock();

        BuyStock buyStockOrder = new BuyStock(stock);
        SellStock sellStockOrder = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }

}
