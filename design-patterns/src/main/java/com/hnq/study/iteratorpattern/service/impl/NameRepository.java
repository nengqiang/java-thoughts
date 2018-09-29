package com.hnq.study.iteratorpattern.service.impl;

import com.hnq.study.iteratorpattern.service.IContainer;
import com.hnq.study.iteratorpattern.service.Iterator;

/**
 * @author henengqiang
 * @date 2018/9/29
 */
public class NameRepository implements IContainer {

    private String[] names = {"Robert", "John", "Julie", "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            return this.hasNext() ? names[index++] : null;
        }

    }
}
