package com.hnq.study.iteratorpattern;

import com.hnq.study.iteratorpattern.service.Iterator;
import com.hnq.study.iteratorpattern.service.impl.NameRepository;

/**
 * 创建一个叙述导航方法的 Iterator 接口和一个返回迭代器的 IContainer 接口。实现了 IContainer 接口的实体类将负责实现 Iterator 接口。
 * IteratorPatternDemo，演示类使用实体类 NamesRepository 来打印 NamesRepository 中存储为集合的 Names。
 *
 * @author henengqiang
 * @date 2018/9/29
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        iterate();
    }

    private static void iterate() {
        NameRepository nameRepository = new NameRepository();
        for (Iterator iter = nameRepository.getIterator(); iter.hasNext();) {
            System.out.println("Name: " + iter.next());
        }
    }

}
