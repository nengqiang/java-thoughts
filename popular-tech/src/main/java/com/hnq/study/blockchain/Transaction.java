package com.hnq.study.blockchain;

import com.hnq.study.utils.StringUtils;

import java.security.PublicKey;
import java.security.Signature;
import java.util.ArrayList;

/**
 * @author henengqiang
 * @date 2018/8/22
 */
public class Transaction {

    /**
     * Contains a hash of transaction
     */
    private String transaction;

    /**
     * Senders address/public key
     */
    private PublicKey sender;

    /**
     * Recipients' address/public key
     */
    private PublicKey recipient;

    /**
     * Contains the amount we wish to send to the recipient
     */
    private float value;

    /**
     * This is to prevent anybody else from spending funds in our wallet
     */
    private byte[] signature;

    private ArrayList<TransactionInput> inputs = new ArrayList<>();

    private ArrayList<TransactionOutput> outputs = new ArrayList<>();

    /**
     * A rough count of how many transactions have been generated
     */
    private static int sequence = 0;

    public Transaction(PublicKey sender, PublicKey recipient, float value, ArrayList<TransactionInput> inputs) {
        this.sender = sender;
        this.recipient = recipient;
        this.value = value;
        this.inputs = inputs;
    }

    public boolean processTransaction() {
        if (!verifySignature()) {
            System.out.println("# Transaction Signature failed to verify");
            return false;
        }

        // Gathers transaction inputs (Making sure they are unspent)
        for (TransactionInput input : inputs) {
//            input.getUtxo() =
        }
        return false;
    }

    public boolean verifySignature() {
        String data = StringUtils.getStringFromKey(sender) + StringUtils.getStringFromKey(recipient) + Float.toString(value);
        return verifyECDSASig(sender, data, signature);
    }

    private boolean verifyECDSASig(PublicKey publicKey, String data, byte[] signature) {
        try {
            Signature ecdsaVerify = Signature.getInstance("ECDSA", "BC");
            ecdsaVerify.initVerify(publicKey);
            ecdsaVerify.update(data.getBytes());
            return ecdsaVerify.verify(signature);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}






























