package com.hnq.study.strategy.exampletwo.strategy;

import com.hnq.study.strategy.exampletwo.service.IStrategy;

/**
 * @author henengqiang
 * @date 2018/11/13
 */
public class Context {

    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }

}
