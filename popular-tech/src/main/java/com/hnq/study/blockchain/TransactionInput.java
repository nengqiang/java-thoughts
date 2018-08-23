package com.hnq.study.blockchain;

/**
 * @author henengqiang
 * @date 2018/8/22
 */
public class TransactionInput {

    /**
     * Reference to TransactionOutputs -> transactionId
     */
    private String transactionOutputId;

    /**
     * Contains the Unspent transaction output
     */
    private TransactionOutput utxo;

    public TransactionInput(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }

    @Override
    public String toString() {
        return "TransactionInput{" +
                "transactionOutputId='" + transactionOutputId + '\'' +
                ", utxo=" + utxo +
                '}';
    }

    public String getTransactionOutputId() {
        return transactionOutputId;
    }

    public TransactionOutput getUtxo() {
        return utxo;
    }

}
