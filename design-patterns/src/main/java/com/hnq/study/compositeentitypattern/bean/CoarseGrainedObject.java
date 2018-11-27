package com.hnq.study.compositeentitypattern.bean;

/**
 * @author henengqiang
 * @date 2018/11/27
 */
public class CoarseGrainedObject {

    private DependentObject1 do1 = new DependentObject1();

    private DependentObject2 do2 = new DependentObject2();

    public void setData(String data1, String data2) {
        do1.setData(data1);
        do2.setData(data2);
    }

    public String[] getData() {
        return new String[] {do1.getData(), do2.getData()};
    }

}
