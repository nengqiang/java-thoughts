package com.hnq.study.statepattern.state.impl;

import com.hnq.study.statepattern.entity.Context;
import com.hnq.study.statepattern.state.IState;

/**
 * @author henengqiang
 * @date 2018/11/7
 */
public class StopState implements IState {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state.");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Stop State";
    }

}
