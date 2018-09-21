package com.hnq.study.bridgepattern.service;

/**
 * @author henengqiang
 * @date 2018/9/19
 */
public interface IDraw {

    /**
     * 画圆
     * @param radius    半径
     * @param pointX    x 坐标
     * @param pointY    y 坐标
     */
    void drawCircle(int radius, int pointX, int pointY);

}
