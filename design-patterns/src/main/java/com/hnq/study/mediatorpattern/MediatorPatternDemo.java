package com.hnq.study.mediatorpattern;

import com.hnq.study.mediatorpattern.bean.User;

/**
 *  通过聊天室实例来演示中介者模式。实例中，多个用户可以向聊天室发送消息，聊天室向所有的用户显示消息。
 * 创建两个类 ChatRoom 和 User。User 对象使用 ChatRoom 方法来分享他们的消息。
 * MediatorPatternDemo，演示类使用 User 对象来显示他们之间的通信。
 *
 * @author henengqiang
 * @date 2018/10/12
 */
public class MediatorPatternDemo {

    public static void main(String[] args) {
        mediatorTest();
    }

    private static void mediatorTest() {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi, John!");
        john.sendMessage("Hello, Robert!");
    }

}
