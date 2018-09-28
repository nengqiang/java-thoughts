package com.hnq.study.interpreterpattern.service.impl;

import com.hnq.study.interpreterpattern.service.IExpresion;

/**
 * @author henengqiang
 * @date 2018/9/28
 */
public class AndExpression implements IExpresion {

    private IExpresion expr1;

    private IExpresion expr2;

    public AndExpression(IExpresion expr1, IExpresion expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }

}
