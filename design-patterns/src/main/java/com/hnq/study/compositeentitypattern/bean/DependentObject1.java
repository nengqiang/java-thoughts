package com.hnq.study.compositeentitypattern.bean;

/**
 * @author henengqiang
 * @date 2018/11/27
 */
public class DependentObject1 {

    private String data;

    @Override
    public String toString() {
        return "DependentObject1{" +
                "data='" + data + '\'' +
                '}';
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
