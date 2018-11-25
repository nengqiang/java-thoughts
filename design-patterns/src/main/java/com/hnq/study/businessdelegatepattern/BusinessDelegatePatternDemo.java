package com.hnq.study.businessdelegatepattern;

import com.hnq.study.businessdelegatepattern.business.BusinessDelegate;

/**
 * 创建 Client、BusinessDelegate、IBusinessService、LookUpService、JMSServiceImpl 和 EJBServiceImpl 来表示业务代表模式中的各种实体。
 * BusinessDelegatePatternDemo，演示类使用 BusinessDelegate 和 Client 来演示业务代表模式的用法。
 *
 * @author henengqiang
 * @date 2018/11/23
 */
public class BusinessDelegatePatternDemo {

    public static void main(String[] args) {
        delegateTest();
    }

    private static void delegateTest() {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.setServiceType("EJB");

        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setServiceType("JMS");
        client.doTask();

        businessDelegate.setServiceType("boot");
        client.doTask();
    }

}
