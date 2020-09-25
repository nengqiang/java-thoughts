package com.hnq.study.mediatorpattern.mediator;

import com.hnq.study.mediatorpattern.bean.User;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @author henengqiang
 * @date 2018/10/12
 */
public class ChatRoom {

    public static void showMessage(User user, String message) {
        String dateStr = DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss");
        System.out.println(dateStr + " " + user + " said: " + message);
    }

}
