package com.hnq.study.mementopattern.state;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/10/26
 */
public class CareTask {

    private List<Memento> mementoList = Lists.newArrayList();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }

}
