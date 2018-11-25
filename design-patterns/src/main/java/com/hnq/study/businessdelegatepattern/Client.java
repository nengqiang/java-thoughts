package com.hnq.study.businessdelegatepattern;

import com.hnq.study.businessdelegatepattern.business.BusinessDelegate;

/**
 * @author henengqiang
 * @date 2018/11/23
 */
public class Client {

    BusinessDelegate businessDelegate;

    public Client(BusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    public void doTask() {
        businessDelegate.doTask();
    }

}
