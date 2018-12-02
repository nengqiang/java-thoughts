package com.hnq.study.daopattern.dao;

import com.google.common.collect.Lists;
import com.hnq.study.daopattern.bean.Student;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/11/30
 */
public class StudentDaoImpl implements StudentDao {

    /**
     * 列表当作一个数据库
     */
    List<Student> students;

    public StudentDaoImpl() {
        students = Lists.newArrayList();
        Student student1 = new Student("Robert", 0);
        Student student2 = new Student("John", 1);
        students.add(student1);
        students.add(student2);
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudent(Integer rollNo) {
        return students.get(rollNo);
    }

    @Override
    public void updateStudent(Student student) {
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database.");
    }

    @Override
    public void deleteStudent(Student student) {
        students.remove(student.getRollNo().intValue());
        System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database.");
    }
}
