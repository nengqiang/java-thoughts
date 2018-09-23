package com.hnq.study.filterpattern.service;

import com.hnq.study.filterpattern.bean.Person;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/9/21
 */
public interface ICriteria {

    List<Person> meetCriteria(List<Person> personList);

}
