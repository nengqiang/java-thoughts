package com.hnq.study.util;

import com.google.common.collect.Lists;
import com.hnq.study.bean.ObjectFields;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author henengqiang
 * @date 2018/10/16
 */
public class ReflectUtils {

    /**
     * 根据反射来遍历类的字段属性及其字段值等
     * @param obj   一个 Object 类
     * @return      {@link List<ObjectFields>}
     * @throws IllegalAccessException
     *              异常抛给调用者处理
     */
    public static List<ObjectFields> reflectToGetFields(Object obj) throws IllegalAccessException {
        List<ObjectFields> objectFieldsList = Lists.newArrayList();
        // 获取参数类
        Class cls = obj.getClass();
        // 将参数类转换为对应属性数量的 Field 类型数组（即该类有多少个属性字段 N 转换后的数组长度即为 N）
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            // field.getName()得到对应字段的属性名，field.get(obj)得到对应字段属性值，field.getGenericType()得到对应字段的类型
            ObjectFields objectFields = new ObjectFields();
            objectFields.setFieldName(field.getName());
            objectFields.setFieldValue(field.get(obj).toString());
            objectFields.setFieldType(field.getGenericType().toString());
            objectFieldsList.add(objectFields);
        }
        return objectFieldsList;
    }

}
