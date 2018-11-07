package com.hnq.study.statepattern;

import com.hnq.study.statepattern.entity.Context;
import com.hnq.study.statepattern.state.impl.StartState;
import com.hnq.study.statepattern.state.impl.StopState;

/**
 * 创建一个 IState 接口和实现了 IState 接口的实体状态类。Context 是一个带有某个状态的类。
 * StatePatternDemo，演示类使用 Context 和状态对象来演示 Context 在状态改变时的行为变化。
 *
 * @author henengqiang
 * @date 2018/11/7
 */
public class StatePatternDemo {

    public static void main(String[] args) {
        stateTest();
    }

    private static void stateTest() {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }

}
