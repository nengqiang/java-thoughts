package com.hnq.study.function;

/**
 * @author henengqiang
 * @date 2020/09/14
 */
@FunctionalInterface
public interface MyFunctionInterface {

    /**
     * 修饰符 interface 接口名称{
     *     public abstract 返回值 方法名称(参数列表)
     *     // 其他方式
     * }
     * // public abstract 可以不写 编译器自动加上
     * 修饰符 interface 接口名称{
     *        返回值 方法名称(参数列表)
     *     // 其他方式
     * }
     *
     */
    void func();

}
