package com.hnq.study.filterpattern.service.impl;

import com.hnq.study.filterpattern.bean.Person;
import com.hnq.study.filterpattern.service.ICriteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author henengqiang
 * @date 2018/9/21
 */
public class CriteriaSingleImpl implements ICriteria {

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> singlePersons = new ArrayList<>();
        for (Person person : personList) {
            if ("single".equalsIgnoreCase(person.getMaritalStatus())) {
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }

}
