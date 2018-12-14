package com.hnq.study.transferobjectpattern.bean.bo;

import com.google.common.collect.Lists;
import com.hnq.study.transferobjectpattern.bean.vo.StudentVO;

import java.util.List;

/**
 * 业务对象
 *
 * @author henengqiang
 * @date 2018/12/14
 */
public class StudentBO {

    /**
     * 列表当作一个数据库
     */
    List<StudentVO> studentVOS;

    public StudentBO() {
        studentVOS = Lists.newArrayList();
        StudentVO student1 = new StudentVO("Robert", 0);
        StudentVO student2 = new StudentVO("John", 1);
        studentVOS.add(student1);
        studentVOS.add(student2);
    }

    public void deleteStudent(StudentVO studentVO) {
        studentVOS.remove(studentVO.getRollNo());
        System.out.println("Student: Roll No " + studentVO.getRollNo() + " deleted from database.");
    }

    /**
     * 从数据库检索学生名单
     * @return {@link List<StudentVO>}
     */
    public List<StudentVO> getAllStudents() {
        return studentVOS;
    }

    public StudentVO getStudent(Integer rollNo) {
        return studentVOS.get(rollNo);
    }

    public void updateStudent(StudentVO studentVO) {
        studentVOS.get(studentVO.getRollNo()).setName(studentVO.getName());
        System.out.println("Student: Roll No " + studentVO.getRollNo() + " updated in the database.");
    }
}
