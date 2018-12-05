package com.hnq.study.frontcontrollerpattern.controller;

import com.hnq.study.frontcontrollerpattern.web.HomeView;
import com.hnq.study.frontcontrollerpattern.web.StudentView;

/**
 * @author henengqiang
 * @date 2018/12/5
 */
public class Dispatcher {

    private HomeView homeView;

    private StudentView studentView;

    public Dispatcher() {
        this.homeView = new HomeView();
        this.studentView = new StudentView();
    }

    public void dispatch(String request) {
        if ("STUDENT".equalsIgnoreCase(request)) {
            studentView.show();
        } else {
            homeView.show();
        }
    }
}
