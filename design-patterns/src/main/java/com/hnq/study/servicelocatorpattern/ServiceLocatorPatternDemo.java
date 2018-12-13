package com.hnq.study.servicelocatorpattern;

import com.hnq.study.servicelocatorpattern.context.ServiceLocator;
import com.hnq.study.servicelocatorpattern.service.Service;

/**
 * 创建 ServiceLocator、InitialContext、Cache、Service 作为表示实体的各种对象。Service1 和 Service2 表示实体服务。
 * ServiceLocatorPatternDemo，演示类在这里是作为一个客户端，将使用 ServiceLocator 来演示服务定位器设计模式。
 *
 * @author henengqiang
 * @date 2018/12/13
 */
public class ServiceLocatorPatternDemo {

    public static void main(String[] args) {
        Service service = ServiceLocator.getService("Service1Impl");
        service.execute();
        service = ServiceLocator.getService("Service2Impl");
        service.execute();
        service = ServiceLocator.getService("Service1Impl");
        service.execute();
        service = ServiceLocator.getService("Service2Impl");
        service.execute();
    }

}
