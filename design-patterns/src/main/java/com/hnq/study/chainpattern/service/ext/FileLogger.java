package com.hnq.study.chainpattern.service.ext;

import com.hnq.study.chainpattern.service.AbstractLogger;

/**
 * @author henengqiang
 * @date 2018/9/27
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }

}
