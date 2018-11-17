package com.hnq.study.templatepattern.template;

/**
 * @author henengqiang
 * @date 2018/11/16
 */
public class Cricket extends BaseGame {

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

}
