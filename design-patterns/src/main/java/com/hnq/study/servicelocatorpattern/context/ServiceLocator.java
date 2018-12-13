package com.hnq.study.servicelocatorpattern.context;

import com.hnq.study.servicelocatorpattern.cache.Cache;
import com.hnq.study.servicelocatorpattern.service.Service;

/**
 * @author henengqiang
 * @date 2018/12/13
 */
public class ServiceLocator {

    private static Cache cache;

    static {
        cache = new Cache();
    }

    public static Service getService(String jndiName) {
        Service service = cache.getService(jndiName);
        if (service != null) {
            return service;
        }
        InitialContext context = new InitialContext();
        Service service1 = (Service) context.lookUp(jndiName);
        cache.addService(service1);
        return service1;
    }

}
