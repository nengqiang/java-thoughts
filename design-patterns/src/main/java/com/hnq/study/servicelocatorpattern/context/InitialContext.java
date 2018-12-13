package com.hnq.study.servicelocatorpattern.context;

import com.hnq.study.servicelocatorpattern.service.impl.Service1Impl;
import com.hnq.study.servicelocatorpattern.service.impl.Service2Impl;

/**
 * @author henengqiang
 * @date 2018/12/13
 */
public class InitialContext {

    private static final String SERVICE1 = "SERVICE1IMPL";

    private static final String SERVICE2 = "SERVICE2IMPL";

    public Object lookUp(String jndiName) {
        if (SERVICE1.equalsIgnoreCase(jndiName)) {
            System.out.println("Looking up and creating a new Service1Impl object");
            return new Service1Impl();
        } else if (SERVICE2.equalsIgnoreCase(jndiName)) {
            System.out.println("Looking up and creating a new Service2Impl object");
            return new Service2Impl();
        }
        return null;
    }


}
