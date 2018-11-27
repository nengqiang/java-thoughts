package com.hnq.study.compositeentitypattern;

import com.hnq.study.compositeentitypattern.entity.Client;

/**
 * 创建作为组合实体的 CompositeEntity 对象。CoarseGrainedObject 是一个包含依赖对象的类。
 * CompositeEntityPatternDemo，演示类使用 Client 类来演示组合实体模式的用法。
 *
 * @author henengqiang
 * @date 2018/11/27
 */
public class CompositeEntityPatternDemo {

    public static void main(String[] args) {
        compositeEntityTest();
    }

    private static void compositeEntityTest() {
        Client client = new Client();
        client.setData("book", "water");
        client.printData();
        client.setData("paper", "wall");
        client.printData();
    }

}
