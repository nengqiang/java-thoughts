package com.hnq.study.frontcontrollerpattern.controller;

/**
 * @author henengqiang
 * @date 2018/12/5
 */
public class FrontController {

    private Dispatcher dispatcher;

    public FrontController() {
        this.dispatcher = new Dispatcher();
    }

    private boolean isAuthenticUser() {
        System.out.println("User is authenticated successfully.");
        return true;
    }

    private void trackRequest(String request) {
        System.out.println("Page requested: " + request);
    }

    public void dispatchRequest(String request) {
        // 记录每一个请求
        trackRequest(request);
        // 对用户进行身份验证'
        if (isAuthenticUser()) {
            dispatcher.dispatch(request);
        }
    }
}
