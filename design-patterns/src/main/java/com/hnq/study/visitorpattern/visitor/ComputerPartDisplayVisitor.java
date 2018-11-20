package com.hnq.study.visitorpattern.visitor;

import com.hnq.study.visitorpattern.computer.impl.Computer;
import com.hnq.study.visitorpattern.computer.impl.KeyBoard;
import com.hnq.study.visitorpattern.computer.impl.Monitor;
import com.hnq.study.visitorpattern.computer.impl.Mouse;

/**
 * @author henengqiang
 * @date 2018/11/20
 */
public class ComputerPartDisplayVisitor implements IComputerPartVisitor {

    @Override
    public void visit(KeyBoard keyBoard) {
        display(keyBoard);
    }

    @Override
    public void visit(Mouse mouse) {
        display(mouse);
    }

    @Override
    public void visit(Monitor monitor) {
        display(monitor);
    }

    @Override
    public void visit(Computer computer) {
        display(computer);
    }

    private void display(Object obj) {
        System.out.println("Displaying: " + obj.getClass().getSimpleName());
    }

}
