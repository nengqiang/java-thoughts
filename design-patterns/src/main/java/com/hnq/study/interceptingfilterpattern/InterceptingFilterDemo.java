package com.hnq.study.interceptingfilterpattern;

import com.hnq.study.interceptingfilterpattern.filter.AuthenticationFilter;
import com.hnq.study.interceptingfilterpattern.filter.DebugFilter;
import com.hnq.study.interceptingfilterpattern.manager.FilterManager;
import com.hnq.study.interceptingfilterpattern.manager.Target;

/**
 * 创建 FilterChain、FilterManager、Target、Client 作为表示实体的各种对象。AuthenticationFilter 和 DebugFilter 表示实体过滤器。
 * InterceptingFilterDemo，演示类使用 Client 来演示拦截过滤器设计模式。
 *
 * @author henengqiang
 * @date 2018-12-07
 */
public class InterceptingFilterDemo {

    public static void main(String[] args) {
        interceptingFilterPatterTest();
    }

    private static void interceptingFilterPatterTest() {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());

        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("HOME");
    }

}
