package com.hnq.study.nullpattern;

import com.google.common.collect.Lists;
import com.hnq.study.nullpattern.customer.AbstractCustomer;
import com.hnq.study.nullpattern.factory.CustomerFactory;

import java.util.List;

/**
 *  创建一个定义操作（在这里，是客户的名称）的 AbstractCustomer 抽象类，和扩展了 AbstractCustomer 类的实体类。
 * 工厂类 CustomerFactory 基于客户传递的名字来返回 RealCustomer 或 NullCustomer 对象。
 *  NullPatternDemo，演示类使用 CustomerFactory 来演示空对象模式的用法。
 *
 * @author henengqiang
 * @date 2018/11/9
 */
public class NullPatternDemo {

    private static final String[] NAMES = {"Rob", "Bob", "Julie", "Laura"};

    public static void main(String[] args) {
        getCustomerTest();
    }

    /**
     * 使用 CustomerFactory，基于客户传递的名字，来获取 RealCustomer 或 NullCustomer 对象。
     */
    private static void getCustomerTest() {
        List<AbstractCustomer> customers = Lists.newArrayList();
        for (String name : NAMES) {
            customers.add(CustomerFactory.getCustomer(name));
        }

        System.out.println("Customers: ");
        customers.forEach(customer -> System.out.println(customer.getName()));
    }

}
