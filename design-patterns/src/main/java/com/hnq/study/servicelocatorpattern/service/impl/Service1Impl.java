package com.hnq.study.servicelocatorpattern.service.impl;

import com.hnq.study.servicelocatorpattern.service.Service;

/**
 * @author henengqiang
 * @date 2018/12/13
 */
public class Service1Impl  implements Service {

    @Override
    public String getName() {
        return "Service1Impl";
    }

    @Override
    public void execute() {
        System.out.println("Executing Service1Impl");
    }

}
