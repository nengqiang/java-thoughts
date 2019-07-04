package com.hnq.study.blockchain;

import com.hnq.study.util.StrUtils;

import java.security.PublicKey;

/**
 * @author henengqiang
 * @date 2018/8/22
 */
public class TransactionOutput {

    private String id;

    /**
     * Also known as the owner of these coins
     */
    private PublicKey recipient;

    /**
     * The amount of coins they own
     */
    private float value;

    /**
     * The id of the transaction this output created in
     */
    private String parentTransactionId;

    public TransactionOutput(PublicKey recipient, float value, String parentTransactionId) {
        this.recipient = recipient;
        this.value = value;
        this.parentTransactionId = parentTransactionId;
        this.id = StrUtils.sha256(StrUtils.getStringFromKey(recipient) + Float.toString(value) + parentTransactionId);
    }

    /**
     * Check if the coin belongs to you
     * @param publicKey publicKey
     * @return          true or false
     */
    public boolean isMine(PublicKey publicKey) {
        return publicKey == recipient;
    }

    @Override
    public String toString() {
        return "TransactionOutput{" +
                "id='" + id + '\'' +
                ", recipient=" + recipient +
                ", value=" + value +
                ", parentTransactionId='" + parentTransactionId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public PublicKey getRecipient() {
        return recipient;
    }

    public float getValue() {
        return value;
    }

    public String getParentTransactionId() {
        return parentTransactionId;
    }

}
