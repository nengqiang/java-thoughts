package com.hnq.study.businessdelegatepattern.business;

import com.hnq.study.businessdelegatepattern.service.IBusinessService;

/**
 * @author henengqiang
 * @date 2018/11/23
 */
public class BusinessDelegate {

    private BusinessLookUp lookUpService = new BusinessLookUp();

    private IBusinessService businessService;

    private String serviceType;

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask() {
        businessService = lookUpService.getBusinessService(serviceType);
        if (businessService != null) {
            businessService.doProcessing();
        } else {
            throw new RuntimeException(String.format("没有serviceType=%s对应的服务", serviceType));
        }
    }

}
