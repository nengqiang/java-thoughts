package com.hnq.study.statepattern.state;

import com.hnq.study.statepattern.entity.Context;

/**
 * @author henengqiang
 * @date 2018/11/7
 */
public interface IState {

    void doAction(Context context);

}
