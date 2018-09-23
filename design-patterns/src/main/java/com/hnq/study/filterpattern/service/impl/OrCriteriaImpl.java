package com.hnq.study.filterpattern.service.impl;

import com.hnq.study.filterpattern.bean.Person;
import com.hnq.study.filterpattern.service.ICriteria;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/9/21
 */
public class OrCriteriaImpl implements ICriteria {

    private ICriteria criteria;

    private ICriteria otherCriteria;

    public OrCriteriaImpl(ICriteria criteria, ICriteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> firstCriteriaItems = criteria.meetCriteria(personList);
        List<Person> otherCriteriaItems = otherCriteria.meetCriteria(personList);
        for (Person person : otherCriteriaItems) {
            if (!firstCriteriaItems.contains(person)) {
                firstCriteriaItems.add(person);
            }
        }
        return firstCriteriaItems;
    }

}
