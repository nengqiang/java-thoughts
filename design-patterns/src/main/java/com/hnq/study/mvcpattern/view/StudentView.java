package com.hnq.study.mvcpattern.view;

/**
 * @author henengqiang
 * @date 2018/11/21
 */
public class StudentView {

    public void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }

}
