package com.hnq.study.daopattern;

import com.hnq.study.daopattern.bean.Student;
import com.hnq.study.daopattern.dao.StudentDao;
import com.hnq.study.daopattern.dao.StudentDaoImpl;

/**
 * 创建一个作为模型对象或数值对象的 Student 对象。StudentDao 是数据访问对象接口。StudentDaoImpl 是实现了数据访问对象接口的实体类。
 * DaoPatternDemo，演示类使用 StudentDao 来演示数据访问对象模式的用法。
 *
 * @author henengqiang
 * @date 2018/11/30
 */
public class DaoPatternDemo {

    public static void main(String[] args) {
        daoPatternTest();
    }

    private static void daoPatternTest() {
        StudentDao studentDao = new StudentDaoImpl();

        studentDao.getAllStudents().forEach(System.out::println);

        Student student = studentDao.getAllStudents().get(0);
        student.setName("Michael");
        studentDao.updateStudent(student);
        System.out.println(studentDao.getStudent(0));

    }

}
