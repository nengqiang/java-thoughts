package com.hnq.study.statepattern.entity;

import com.hnq.study.statepattern.state.IState;

/**
 * @author henengqiang
 * @date 2018/11/7
 */
public class Context {

    private IState state;

    public Context() {
        this.state = null;
    }

    @Override
    public String toString() {
        return "Context{" + "state=" + state + '}';
    }

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        this.state = state;
    }

}
