package com.hnq.study.chainpattern.service.ext;

import com.hnq.study.chainpattern.service.AbstractLogger;

/**
 * @author henengqiang
 * @date 2018/9/27
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }

}
