package com.hnq.study.visitorpattern;

import com.hnq.study.visitorpattern.computer.IComputerPart;
import com.hnq.study.visitorpattern.computer.impl.Computer;
import com.hnq.study.visitorpattern.visitor.ComputerPartDisplayVisitor;

/**
 *  创建一个定义接受操作的 IComputerPart 接口。Keyboard、Mouse、Monitor 和 Computer 是实现了 IComputerPart 接口的实体类。
 * 定义另一个接口 IComputerPartVisitor，它定义了访问者类的操作。Computer 使用实体访问者来执行相应的动作。
 * VisitorPatternDemo，演示类使用 Computer、IComputerPartVisitor 类来演示访问者模式的用法。
 *
 * @author henengqiang
 * @date 2018/11/20
 */
public class VisitorPatternDemo {

    public static void main(String[] args) {
        visitorTest();
    }

    private static void visitorTest() {
        IComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }

}
