package com.hnq.study.businessdelegatepattern.service.impl;

import com.hnq.study.businessdelegatepattern.service.IBusinessService;

/**
 * @author henengqiang
 * @date 2018/11/23
 */
public class JMSServiceImpl implements IBusinessService {

    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking JMS Service");
    }

}
