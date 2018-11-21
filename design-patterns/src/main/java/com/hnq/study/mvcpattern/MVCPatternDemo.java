package com.hnq.study.mvcpattern;

import com.hnq.study.mvcpattern.controller.StudentController;
import com.hnq.study.mvcpattern.model.Student;
import com.hnq.study.mvcpattern.view.StudentView;

/**
 *  创建一个作为模型的 Student 对象。StudentView 是一个把学生详细信息输出到控制台的视图类，
 * StudentController 是负责存储数据到 Student 对象中的控制器类，并相应地更新视图 StudentView。
 *  MVCPatternDemo，演示类使用 StudentController 来演示 MVC 模式的用法。
 *
 * @author henengqiang
 * @date 2018/11/21
 */
public class MVCPatternDemo {

    public static void main(String[] args) {
        mvcTest();
    }

    private static void mvcTest() {
        // 从数据库获取学生记录
        Student model = getStudentFromDataBase();

        // 创建一个视图，把学生详细信息输出到控制台
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);
        controller.updateView();

        // 更新模型数据
        controller.setStudentName("John");
        controller.updateView();
    }

    private static Student getStudentFromDataBase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }

}
