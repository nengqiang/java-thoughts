package com.hnq.study.visitorpattern.computer.impl;

import com.hnq.study.visitorpattern.computer.IComputerPart;
import com.hnq.study.visitorpattern.visitor.IComputerPartVisitor;

/**
 * @author henengqiang
 * @date 2018/11/20
 */
public class KeyBoard implements IComputerPart {

    @Override
    public void accept(IComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }

}
