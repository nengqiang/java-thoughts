package com.hnq.study.visitorpattern.computer.impl;

import com.hnq.study.visitorpattern.computer.IComputerPart;
import com.hnq.study.visitorpattern.visitor.IComputerPartVisitor;

/**
 * @author henengqiang
 * @date 2018/11/20
 */
public class Computer implements IComputerPart {

    private IComputerPart[] parts;

    public Computer() {
        this.parts = new IComputerPart[] {new Mouse(), new KeyBoard(), new Monitor()};
    }

    @Override
    public void accept(IComputerPartVisitor computerPartVisitor) {
        for (IComputerPart part : parts) {
            part.accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }

}
