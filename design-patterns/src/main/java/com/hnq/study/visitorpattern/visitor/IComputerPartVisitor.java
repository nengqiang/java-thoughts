package com.hnq.study.visitorpattern.visitor;

import com.hnq.study.visitorpattern.computer.impl.Computer;
import com.hnq.study.visitorpattern.computer.impl.KeyBoard;
import com.hnq.study.visitorpattern.computer.impl.Monitor;
import com.hnq.study.visitorpattern.computer.impl.Mouse;

/**
 * 表示访问者的接口
 *
 * @author henengqiang
 * @date 2018/11/20
 */
public interface IComputerPartVisitor {

    void visit(KeyBoard keyBoard);

    void visit(Mouse mouse);

    void visit(Monitor monitor);

    void visit(Computer computer);

}
