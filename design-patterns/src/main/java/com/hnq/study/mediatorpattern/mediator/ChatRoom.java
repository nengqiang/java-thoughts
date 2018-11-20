package com.hnq.study.mediatorpattern.mediator;

import com.hnq.study.mediatorpattern.bean.User;
import com.hnq.study.utils.DateUtil;

import java.util.Date;

/**
 * @author henengqiang
 * @date 2018/10/12
 */
public class ChatRoom {

    public static void showMessage(User user, String message) {
        String dateStr = DateUtil.dateToString(new Date(), "yyyy-MM-dd hh:mm:ss");
        System.out.println(dateStr + " " + user + " said: " + message);
    }

}