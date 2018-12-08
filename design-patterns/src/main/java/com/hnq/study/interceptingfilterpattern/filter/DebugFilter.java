package com.hnq.study.interceptingfilterpattern.filter;

/**
 * @author henengqiang
 * @date 2018-12-07
 */
public class DebugFilter implements Filter {

    @Override
    public void execute(String request) {
        System.out.println("request log: " + request);
    }

}
