package com.hnq.study.blockchain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 区块:
 *  一个基本的区块定义，hash保存区块的电子签名，previousHash保存上⼀个区块的电子签名，
 * data是数据/交易信息。
 *
 * @author henengqiang
 * @date 2018/8/22
 */
public class Block implements Serializable {

    private static final long serialVersionUID = 8267347605292381913L;

    private String hash;

    private String previousHash;

    /**
     * our data will be a simple message
     */
    private String data;

//    private ArrayList

}
