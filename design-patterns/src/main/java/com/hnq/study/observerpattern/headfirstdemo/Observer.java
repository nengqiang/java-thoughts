package com.hnq.study.observerpattern.headfirstdemo;

/**
 * @author henengqiang
 * @date 2020/8/3
 */
public interface Observer {

    void update(float temperature, float humidity, float pressure);

}
