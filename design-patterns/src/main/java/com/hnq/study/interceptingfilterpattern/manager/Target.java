package com.hnq.study.interceptingfilterpattern.manager;

/**
 * @author henengqiang
 * @date 2018-12-07
 */
public class Target {

    public void execute(String request) {
        System.out.println("Executing request: " + request);
    }

}
