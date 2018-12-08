package com.hnq.study.interceptingfilterpattern.filter;

/**
 * @author henengqiang
 * @date 2018-12-07
 */
public class AuthenticationFilter implements Filter {

    @Override
    public void execute(String request) {
        System.out.println("Authenticating request: " + request);
    }

}
