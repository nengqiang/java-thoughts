package com.hnq.study.typicalframework;

/**
 * @author henengqiang
 * @date 2018/8/20
 */
public class Context {

    /**
     * 持有一个具体策略对象
     */
    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 策略方法
     */
    public void contextMethod() {
        strategy.strategyMethod();
    }

}
