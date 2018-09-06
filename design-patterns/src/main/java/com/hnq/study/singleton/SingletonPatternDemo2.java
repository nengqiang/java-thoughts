package com.hnq.study.singleton;

import com.hnq.study.singleton.bean.SingleObject;

/**
 * @author henengqiang
 * @date 2018/9/6
 */
public class SingletonPatternDemo2 {

    public static void main(String[] args) {
        SingleObject object = SingleObject.getInstance();
        Thread t1 = new Thread(() -> {object.showMessage("01"); System.out.println(object);});
        Thread t2 = new Thread(() -> {object.showMessage("02"); System.out.println(object);});
        Thread t3 = new Thread(() -> {object.showMessage("03"); System.out.println(object);});
        Thread t4 = new Thread(() -> {object.showMessage("04"); System.out.println(object);});
        Thread t5 = new Thread(() -> {object.showMessage("05"); System.out.println(object);});
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}
