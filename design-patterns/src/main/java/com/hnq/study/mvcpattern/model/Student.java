package com.hnq.study.mvcpattern.model;

import java.io.Serializable;

/**
 * @author henengqiang
 * @date 2018/11/21
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 4937258534899751187L;

    private String rollNo;

    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "rollNo='" + rollNo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
