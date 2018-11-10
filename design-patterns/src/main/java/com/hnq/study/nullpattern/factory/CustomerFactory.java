package com.hnq.study.nullpattern.factory;

import com.hnq.study.nullpattern.customer.AbstractCustomer;
import com.hnq.study.nullpattern.customer.NullCustomer;
import com.hnq.study.nullpattern.customer.RealCustomer;

/**
 * @author henengqiang
 * @date 2018/11/9
 */
public class CustomerFactory {

    private static final String[] NAMES = {"Rob", "Joe", "Julie"};

    public static AbstractCustomer getCustomer(String inputName) {
        for (String name : NAMES) {
            if (name.equalsIgnoreCase(inputName)) {
                return new RealCustomer(inputName);
            }
        }
        return new NullCustomer();
    }

}
