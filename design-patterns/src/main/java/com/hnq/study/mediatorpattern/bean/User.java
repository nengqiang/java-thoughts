package com.hnq.study.mediatorpattern.bean;

import com.hnq.study.mediatorpattern.mediator.ChatRoom;

/**
 * @author henengqiang
 * @date 2018/10/12
 */
public class User {

    private String name;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
