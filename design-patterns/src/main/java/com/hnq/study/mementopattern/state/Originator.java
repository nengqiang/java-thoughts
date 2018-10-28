package com.hnq.study.mementopattern.state;

/**
 * @author henengqiang
 * @date 2018/10/26
 */
public class Originator {

    private String state;

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }

    @Override
    public String toString() {
        return "Originator{" + "state='" + state + '\'' + '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
