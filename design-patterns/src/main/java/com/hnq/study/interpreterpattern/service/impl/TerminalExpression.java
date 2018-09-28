package com.hnq.study.interpreterpattern.service.impl;

import com.hnq.study.interpreterpattern.service.IExpresion;

/**
 * @author henengqiang
 * @date 2018/9/28
 */
public class TerminalExpression implements IExpresion {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }

}
