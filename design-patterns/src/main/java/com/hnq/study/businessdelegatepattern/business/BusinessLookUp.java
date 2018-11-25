package com.hnq.study.businessdelegatepattern.business;

import com.hnq.study.businessdelegatepattern.service.IBusinessService;
import com.hnq.study.businessdelegatepattern.service.impl.EJBServiceImpl;
import com.hnq.study.businessdelegatepattern.service.impl.JMSServiceImpl;

/**
 * @author henengqiang
 * @date 2018/11/23
 */
public class BusinessLookUp {

    // service name

    private static final String EJB = "EJB";

    private static final String JMS = "JMS";

    /**
     * 根据服务名获取对应服务对象
     * @param serviceType   服务名
     * @return              找不到对应服务时返回【null】
     */
    public IBusinessService getBusinessService(String serviceType) {
        switch (serviceType) {
            case EJB: return new EJBServiceImpl();
            case JMS: return new JMSServiceImpl();
            // default 这里也可以提供一个默认服务
            default: return null;
        }
    }

}
