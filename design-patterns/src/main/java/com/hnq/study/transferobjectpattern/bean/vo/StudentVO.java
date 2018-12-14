package com.hnq.study.transferobjectpattern.bean.vo;

/**
 * 传输对象（视图对象）
 *
 * @author henengqiang
 * @date 2018/12/14
 */
public class StudentVO {

    private String name;

    private Integer rollNo;

    public StudentVO(String name, Integer rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }
}
