package com.hnq.study.interceptingfilterpattern.manager;

import com.hnq.study.interceptingfilterpattern.filter.Filter;
import com.hnq.study.interceptingfilterpattern.filter.FilterChain;

/**
 * @author henengqiang
 * @date 2018-12-07
 */
public class FilterManager {

    private FilterChain filterChain;

    public FilterManager(Target target) {
        this.filterChain = new FilterChain();
        filterChain.setTarget(target);
    }

    public void setFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request) {
        filterChain.execute(request);
    }
}
