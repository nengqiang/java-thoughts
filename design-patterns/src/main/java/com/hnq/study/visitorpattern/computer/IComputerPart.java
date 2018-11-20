package com.hnq.study.visitorpattern.computer;

import com.hnq.study.visitorpattern.visitor.IComputerPartVisitor;

/**
 * @author henengqiang
 * @date 2018/11/20
 */
public interface IComputerPart {

    void accept(IComputerPartVisitor computerPartVisitor);

}
