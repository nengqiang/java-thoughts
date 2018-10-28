package com.hnq.study.blockchain;

import com.hnq.study.utils.StringUtil;

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

    /**
     * our data will be a simple message
     */
    private ArrayList<Transaction> transactions = new ArrayList<>();

    /**
     * as number of milliseconds since 1970/1/1
     */
    private long timeStamp;

    private int nonce;

    public Block(String previousHash, String data) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = System.currentTimeMillis();
        this.hash = calculateHash();
    }

    public Block(String previousHash) {
        this.previousHash = previousHash;
        this.timeStamp = System.currentTimeMillis();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        return StringUtil.sha256(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data);
    }

    public void mineBlock(int difficulty) {
        String target = getDifficultyString(difficulty);
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block MINED!!! : " + hash);
    }

    public boolean addTransaction(Transaction transaction) {
        if (transaction == null) {
            return false;
        }
        if (!"0".equals(previousHash)) {
            if (!transaction.processTransaction()) {
                System.out.println("Transaction failed to process. Discarded.");
                return false;
            }
        }
        transactions.add(transaction);
        System.out.println("Transaction successfully added to Block.");
        return true;
    }

    private String getDifficultyString(int difficulty) {
        return new String(new char[difficulty]).replace("\0", "0");
    }

    @Override
    public String toString() {
        return "Block{" +
                "hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", data='" + data + '\'' +
                ", transactions=" + transactions +
                ", timeStamp=" + timeStamp +
                ", nonce=" + nonce +
                '}';
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public int getNonce() {
        return nonce;
    }

}
