package com.hnq.study.strategy.exampletwo.service.impl;

import com.hnq.study.strategy.exampletwo.service.IStrategy;

/**
 * @author henengqiang
 * @date 2018/11/13
 */
public class OperationMultiply implements IStrategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }

}
