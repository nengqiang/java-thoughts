package com.hnq.study.interceptingfilterpattern.filter;

import com.google.common.collect.Lists;
import com.hnq.study.interceptingfilterpattern.manager.Target;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018-12-07
 */
public class FilterChain {

    private List<Filter> filters = Lists.newArrayList();

    private Target target;

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void execute(String request) {
        filters.forEach(filter -> filter.execute(request));
        target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }

}
