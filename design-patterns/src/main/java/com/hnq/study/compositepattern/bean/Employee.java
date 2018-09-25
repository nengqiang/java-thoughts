package com.hnq.study.compositepattern.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author henengqiang
 * @date 2018/9/25
 */
public class Employee {

    private String name;

    private String dept;

    private Double salary;

    private List<Employee> subordinates;

    public Employee(String name, String dept, Double salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        subordinates = new ArrayList<>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", subordinates=" + subordinates +
                '}';
    }

}
