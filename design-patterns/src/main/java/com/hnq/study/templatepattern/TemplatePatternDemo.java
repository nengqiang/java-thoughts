package com.hnq.study.templatepattern;

import com.hnq.study.templatepattern.template.BaseGame;
import com.hnq.study.templatepattern.template.Cricket;
import com.hnq.study.templatepattern.template.FootBall;

/**
 * 创建一个定义操作的 BaseGame 抽象类，其中，模板方法设置为 final，这样它就不会被重写。
 * Cricket 和 Football 是扩展了 BaseGame 的实体类，它们重写了抽象类的方法。
 * TemplatePatternDemo，演示类使用 BaseGame 来演示模板模式的用法。
 *
 * @author henengqiang
 * @date 2018/11/16
 */
public class TemplatePatternDemo {

    public static void main(String[] args) {
        gamePlay();
    }

    private static void gamePlay() {
        BaseGame game = new Cricket();
        game.play();
        game = new FootBall();
        game.play();
    }

}
