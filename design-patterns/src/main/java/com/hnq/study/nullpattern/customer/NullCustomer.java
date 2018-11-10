package com.hnq.study.nullpattern.customer;

/**
 * @author henengqiang
 * @date 2018/11/9
 */
public class NullCustomer extends AbstractCustomer {

    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }
}
