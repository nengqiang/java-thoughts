package com.hnq.study.strategy.exampletwo;

import com.hnq.study.strategy.exampletwo.service.impl.OperationAdd;
import com.hnq.study.strategy.exampletwo.service.impl.OperationMultiply;
import com.hnq.study.strategy.exampletwo.service.impl.OperationSubstract;
import com.hnq.study.strategy.exampletwo.strategy.Context;

/**
 * 创建一个定义活动的 IStrategy 接口和实现了 IStrategy 接口的实体策略类。Context 是一个使用了某种策略的类。
 * StrategyPatternDemo，演示类使用 Context 和策略对象来演示 Context 在它所配置或使用的策略改变时的行为变化。
 *
 * @author henengqiang
 * @date 2018/11/13
 */
public class StrategyPatternDemo {

    public static void main(String[] args) {
        strategyTest(10, 5);
        System.out.println("--------------------");
        strategyTest(11, 4);
    }

    private static void strategyTest(int num1, int num2) {
        Context context = new Context(new OperationAdd());
        System.out.println(String.format("%d + %d = %d", num1, num2, context.executeStrategy(num1, num2)));

        context = new Context(new OperationSubstract());
        System.out.println(String.format("%d - %d = %d", num1, num2, context.executeStrategy(num1, num2)));

        context = new Context(new OperationMultiply());
        System.out.println(String.format("%d * %d = %d", num1, num2, context.executeStrategy(num1, num2)));
    }

}
