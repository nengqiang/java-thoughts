package com.hnq.study.interpreterpattern;

import com.hnq.study.interpreterpattern.service.IExpresion;
import com.hnq.study.interpreterpattern.service.impl.AndExpression;
import com.hnq.study.interpreterpattern.service.impl.OrExpression;
import com.hnq.study.interpreterpattern.service.impl.TerminalExpression;

/**
 *  创建一个接口 IExpression 和实现了 IExpression 接口的实体类。定义作为上下文中主要解释器的 TerminalExpression 类。
 * 其他的类 OrExpression、AndExpression 用于创建组合式表达式。
 * InterpreterPatternDemo，演示类使用 IExpression 类创建规则和演示表达式的解析。
 *
 * @author henengqiang
 * @date 2018/9/28
 */
public class InterpreterPatternDemo {

    public static void main(String[] args) {
        interpret();
    }

    private static void interpret() {
        IExpresion isMale = getMaleExpression();
        IExpresion isMarriedWoman = getMarriedWomanExpression();
        System.out.println("John is male? : " + isMale.interpret("John"));
        System.out.println("Julie is a married woman? : " + isMarriedWoman.interpret("Married Julie"));
    }

    /**
     * 规则1：Robert 和 John 是男性
     */
    private static IExpresion getMaleExpression() {
       IExpresion robert = new TerminalExpression("Robert");
       IExpresion john = new TerminalExpression("John");
       return new OrExpression(robert, john);
    }

    /**
     * 规则2：Julie 是一个已婚女性
     */
    private static IExpresion getMarriedWomanExpression() {
       IExpresion julie = new TerminalExpression("Julie");
       IExpresion married = new TerminalExpression("Married");
       return new AndExpression(julie, married);
    }

}
