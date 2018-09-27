package com.hnq.study.chainpattern;

import com.hnq.study.chainpattern.service.AbstractLogger;
import com.hnq.study.chainpattern.service.ext.ConsoleLogger;
import com.hnq.study.chainpattern.service.ext.ErrorLogger;
import com.hnq.study.chainpattern.service.ext.FileLogger;

/**
 *  创建抽象类 AbstractLogger，带有详细的日志记录级别。然后创建三种类型的记录器，都扩展了 AbstractLogger。
 * 每个记录器消息的级别是否属于自己的级别，如果是则相应地打印出来，否则将不打印并把消息传给下一个记录器。
 *
 * 创建不同类型的记录器。赋予它们不同的错误级别，并在每个记录器中设置下一个记录器。每个记录器中的下一个记录器代表的是链的一部分。
 *
 * @author henengqiang
 * @date 2018/9/27
 */
public class ChainPatternDemo {

    public static void main(String[] args) {
        pushRequestToChain();
    }

    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }

    private static void pushRequestToChain() {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is a debug level information.");
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
    }

}
