package com.hnq.study.servicelocatorpattern.cache;

import com.google.common.collect.Lists;
import com.hnq.study.servicelocatorpattern.service.Service;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/12/13
 */
public class Cache {

    private List<Service> services;

    public Cache() {
        services = Lists.newArrayList();
    }

    public Service getService(String serviceName) {
        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(serviceName)) {
                System.out.println("Returning cached " + serviceName + " object");
                return service;
            }
        }
        return null;
    }

    public void addService(Service newService) {
        boolean exist = false;
        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(newService.getName())) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            services.add(newService);
        }
    }
}
