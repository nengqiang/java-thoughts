package com.hnq.study.daopattern.dao;

import com.hnq.study.daopattern.bean.Student;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/11/30
 */
public interface StudentDao {

    List<Student> getAllStudents();

    Student getStudent(Integer rollNo);

    void updateStudent(Student student);

    void deleteStudent(Student student);

}
