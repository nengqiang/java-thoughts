package com.hnq.study.strategy.anexample;

import com.hnq.study.strategy.anexample.bean.Player;

/**
 * @author henengqiang
 * @date 2018/8/21
 */
public class Client {

    public static void main(String[] args) {
        /*
         *  运行以后会发现，第一次是原价，第二次是九折，第三次是八折，最后一次则是七价。
         * 这样设计的好处是，客户不再依赖于具体的收费策略，依赖于抽象永远是正确的。
         */
        chargePattern();
    }

    private static void chargePattern() {
        Player player = new Player();
        player.buy(5000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());

        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());

        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());

        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
    }

}
