package com.hnq.study.utils;

import java.lang.reflect.Field;

/**
 * @author henengqiang
 * @date 2018/10/16
 */
public class ReflectUtil {

    /**
     * 根据反射来遍历类的字段属性及其字段值
     * @param obj   一个 Object 类
     */
    public static void reflectToGetFields(Object obj) {
        // 获取参数类
        Class cls = obj.getClass();
        // 将参数类转换为对应属性数量的 Field 类型数组（即该类有多少个属性字段 N 转换后的数组长度即为 N）
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                // field.getName()得到对应字段的属性名，field.get(obj)得到对应字段属性值，field.getGenericType()得到对应字段的类型
                System.out.println("属性名：" + field.getName() + "，属性值：" + field.get(obj) + "，字段类型：" + field.getGenericType());
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
