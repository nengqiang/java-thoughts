package com.hnq.study.bean;

import java.io.Serializable;

/**
 * 类的字段属性及其字段值等 的封装对象
 * @author henengqiang
 * @date 2018/11/9
 */
public class ObjectFields implements Serializable {

    private static final long serialVersionUID = -4481776839209893271L;

    /**
     * 属性名
     */
    private String fieldName;

    /**
     * 属性值
     */
    private String fieldValue;

    /**
     * 字段类型
     */
    private String fieldType;

    @Override
    public String toString() {
        return "ObjectFields{" +
                "fieldName='" + fieldName + '\'' +
                ", fieldValue='" + fieldValue + '\'' +
                ", fieldType='" + fieldType + '\'' +
                '}';
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

}
