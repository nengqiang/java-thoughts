package com.hnq.study.nullpattern.customer;

/**
 * @author henengqiang
 * @date 2018/11/9
 */
public class RealCustomer extends AbstractCustomer {

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

}
