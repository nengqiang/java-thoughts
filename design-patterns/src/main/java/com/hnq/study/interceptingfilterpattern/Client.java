package com.hnq.study.interceptingfilterpattern;

import com.hnq.study.interceptingfilterpattern.manager.FilterManager;

/**
 * @author henengqiang
 * @date 2018-12-07
 */
public class Client {

    private FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public void sendRequest(String request) {
        filterManager.filterRequest(request);
    }
}
