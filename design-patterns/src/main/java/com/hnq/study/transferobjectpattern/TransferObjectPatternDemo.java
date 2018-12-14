package com.hnq.study.transferobjectpattern;

import com.hnq.study.transferobjectpattern.bean.bo.StudentBO;
import com.hnq.study.transferobjectpattern.bean.vo.StudentVO;

/**
 * 创建一个作为业务对象的 StudentBO 和作为传输对象的 StudentVO，它们都代表了我们的实体。
 * TransferObjectPatternDemo，演示类在这里是作为一个客户端，将使用 StudentBO 和 Student 来演示传输对象设计模式。
 *
 * @author henengqiang
 * @date 2018/12/14
 */
public class TransferObjectPatternDemo {

    public static void main(String[] args) {
        StudentBO studentBO = new StudentBO();

        // 输出所有学生
        studentBO.getAllStudents().forEach(System.out::println);

        // 更新学生
        StudentVO studentVO = studentBO.getAllStudents().get(0);
        studentVO.setName("Machael");
        studentBO.updateStudent(studentVO);

        // 获取学生
        System.out.println(studentBO.getStudent(0));
    }

}
