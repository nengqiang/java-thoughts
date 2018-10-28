package com.hnq.study.mementopattern.state;

/**
 * @author henengqiang
 * @date 2018/10/26
 */
public class Memento {

    private String state;

    public Memento() {}

    public Memento(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Memento{" + "state='" + state + '\'' + '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
