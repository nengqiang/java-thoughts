package com.hnq.study.mvcpattern.controller;

import com.hnq.study.mvcpattern.model.Student;
import com.hnq.study.mvcpattern.view.StudentView;

/**
 * @author henengqiang
 * @date 2018/11/21
 */
public class StudentController {

    private Student model;

    private StudentView view;

    public StudentController() {}

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public String toString() {
        return "StudentController{" +
                "model=" + model +
                ", view=" + view +
                '}';
    }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }

    public void setStudentName(String studentName) {
        model.setName(studentName);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentRollNo(String rollNo) {
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo() {
        return model.getRollNo();
    }

}
