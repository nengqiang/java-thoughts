package com.hnq.study.mementopattern;

import com.hnq.study.mementopattern.state.CareTask;
import com.hnq.study.mementopattern.state.Originator;

/**
 * 备忘录模式使用三个类 Memento、Originator 和 CareTaker。Memento 包含了要被恢复的对象的状态。
 * Originator 创建并在 Memento 对象中存储状态。Caretaker 对象负责从 Memento 中恢复对象的状态。
 * MementoPatternDemo，演示类使用 CareTaker 和 Originator 对象来显示对象的状态恢复。
 *
 * @author henengqiang
 * @date 2018/10/26
 */
public class MementoPatternDemo {

    public static void main(String[] args) {
        mementoTest();
    }

    private static void mementoTest() {
        Originator originator = new Originator();
        CareTask careTask = new CareTask();

        originator.setState("State #1");
        originator.setState("State #2");
        careTask.add(originator.saveStateToMemento());
        originator.setState("State #3");
        careTask.add(originator.saveStateToMemento());
        originator.setState("State #4");

        System.out.println("Current state: " + originator.getState());
        originator.getStateFromMemento(careTask.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTask.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }

}
