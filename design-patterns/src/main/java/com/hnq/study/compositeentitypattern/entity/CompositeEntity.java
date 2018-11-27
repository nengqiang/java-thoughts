package com.hnq.study.compositeentitypattern.entity;

import com.hnq.study.compositeentitypattern.bean.CoarseGrainedObject;

/**
 * @author henengqiang
 * @date 2018/11/27
 */
public class CompositeEntity {

    private CoarseGrainedObject cgo = new CoarseGrainedObject();

    public void setData(String data1, String data2) {
        cgo.setData(data1, data2);
    }

    public String[] getData() {
        return cgo.getData();
    }

}
