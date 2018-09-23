package com.hnq.study.filterpattern.service.impl;

import com.hnq.study.filterpattern.bean.Person;
import com.hnq.study.filterpattern.service.ICriteria;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/9/21
 */
public class AndCriteriaImpl implements ICriteria {

    private ICriteria criteria;

    private ICriteria otherCriteria;

    public AndCriteriaImpl(ICriteria criteria, ICriteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(personList);
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }

}
