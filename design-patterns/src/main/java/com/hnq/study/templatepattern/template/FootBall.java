package com.hnq.study.templatepattern.template;

/**
 * @author henengqiang
 * @date 2018/11/16
 */
public class FootBall extends BaseGame {

    @Override
    void initialize() {
        System.out.println("FootBall Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("FootBall Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("FootBall Game Finished!");
    }

}
