package com.hnq.study.proxypattern;

import com.hnq.study.proxypattern.service.Image;
import com.hnq.study.proxypattern.service.ProxyImage;

/**
 * 创建一个 Image 接口和实现了 Image 接口的实体类。ProxyImage 是一个代理类，减少 RealImage 对象加载的内存占用。
 * ProxyPatternDemo，演示类使用 ProxyImage 来获取要加载的 Image 对象，并按照需求进行显示。
 *
 * @author henengqiang
 * @date 2018/9/27
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        display();
    }

    private static void display() {
        Image image = new ProxyImage("webapp.png");
        // 图像从磁盘加载
        image.display();
        // 图像不需要从磁盘加载
        image.display();
    }

}
