package com.hnq.study.optimizetheexample;

import com.hnq.study.optimizetheexample.bean.Player;

/**
 * @author henengqiang
 * @date 2018/8/21
 */
public class Client {

    public static void main(String[] args) {
        chargePattern();
    }

    private static void chargePattern() {
        Player player = new Player();
        player.buy(4800D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());

        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());

        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());

        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
    }

}
