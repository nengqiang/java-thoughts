package com.hnq.study.templatepattern.template;

/**
 * @author henengqiang
 * @date 2018/11/16
 */
public abstract class BaseGame {

    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    /**
     * 模板
     */
    public final void play() {
        // 初始化游戏
        initialize();
        // 开始游戏
        startPlay();
        // 结束游戏
        endPlay();
    }

}
