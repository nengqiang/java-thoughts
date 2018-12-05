package com.hnq.study.frontcontrollerpattern;

import com.hnq.study.frontcontrollerpattern.controller.FrontController;

/**
 * 创建 FrontController、Dispatcher 分别当作前端控制器和调度器。HomeView 和 StudentView 表示各种为前端控制器接收到的请求而创建的视图。
 * FrontControllerPatternDemo，演示类使用 FrontController 来演示前端控制器设计模式。
 *
 * @author henengqiang
 * @date 2018/12/5
 */
public class FrontControllerPatternDemo {

    public static void main(String[] args) {
        controllerTest();
    }

    private static void controllerTest() {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("HOME");
        frontController.dispatchRequest("STUDENT");
    }

}
