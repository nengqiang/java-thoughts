package com.hnq.study.prototypepattern.father;

/**
 * 创建一个实现了 Cloneable 接口的抽象类。
 *
 * @author henengqiang
 * @date 2018/9/13
 */
public abstract class AbstractShape implements Cloneable {

    private String id;

    protected String type;

    protected abstract void draw();

    @Override
    public String toString() {
        return "AbstractShape{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
