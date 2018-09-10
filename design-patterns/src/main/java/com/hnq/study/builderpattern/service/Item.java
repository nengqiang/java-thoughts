package com.hnq.study.builderpattern.service;

/**
 * 表示食物条目的接口
 *
 * @author henengqiang
 * @date 2018/9/10
 */
public interface Item {

    String name();

    Packing packing();

    float price();

}
