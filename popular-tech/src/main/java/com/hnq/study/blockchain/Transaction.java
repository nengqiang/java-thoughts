package com.hnq.study.blockchain;

import com.hnq.study.utils.StringUtil;

import java.security.PrivateKey;
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
    private String transactionId;

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

        NoobChain noobChain = new NoobChain();
        // Gathers transaction inputs (Making sure they are unspent)
        for (TransactionInput input : inputs) {
            input.setUtxo(noobChain.getUtxos().get(input.getTransactionOutputId()));
        }

        // Checks if transaction is valid
        if (getInputsValue() < noobChain.getMinimumTransaction()) {
            System.out.println("Transaction inputs too small: " + getInputsValue());
            System.out.println("Please enter the amount greater than " + noobChain.getMinimumTransaction());
            return false;
        }

        // Generate transaction outputs
        // Get value of inputs then the left over change
        float leftOver = getInputsValue() - value;
        transactionId = calculateHash();
        // Send value to recipient
        outputs.add(new TransactionOutput(this.recipient, value, transactionId));
        // Send the left over 'change' back to sender
        outputs.add(new TransactionOutput(this.sender, leftOver, transactionId));

        // Add outputs to unspent list
        for (TransactionOutput output : outputs) {
            noobChain.getUtxos().put(output.getId(), output);
        }

        // Remove transaction inputs from utxo lists as spent:
        for (TransactionInput input : inputs) {
            // If transaction can't be found, skip it
            if (input.getUtxo() == null) {
                continue;
            }
            noobChain.getUtxos().remove(input.getUtxo().getId());
        }
        return true;
    }

    public boolean verifySignature() {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(recipient) + Float.toString(value);
        return verifyECDSASig(sender, data, signature);
    }

    public float getInputsValue() {
        float total = 0;
        for (TransactionInput input : inputs) {
            if (input.getUtxo() == null) {
                // If transaction can't be found, skip it. This behavior may not be optional
                continue;
            }
            total += input.getUtxo().getValue();
        }
        return total;
    }

    public float getOutputsValue() {
        float total = 0;
        for (TransactionOutput output : outputs) {
            total += output.getValue();
        }
        return total;
    }

    public void generateSignature(PrivateKey privateKey) {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(recipient) + Float.toString(value);
        signature = applyECDSASig(privateKey, data);
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

    private String calculateHash() {
        // Increase the sequence to avoid 2 identical transactions having the same hash
        sequence++;
        return StringUtil.sha256(
                StringUtil.getStringFromKey(sender) +
                        StringUtil.getStringFromKey(recipient) +
                        Float.toString(value) + sequence
        );
    }

    private byte[] applyECDSASig(PrivateKey privateKey, String input) {
        Signature dsa;
        byte[] output;
        try {
            dsa = Signature.getInstance("ECDSA", "BC");
            dsa.initSign(privateKey);
            byte[] strByte = input.getBytes();
            dsa.update(strByte);
            output = dsa.sign();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public PublicKey getSender() {
        return sender;
    }

    public PublicKey getRecipient() {
        return recipient;
    }

    public float getValue() {
        return value;
    }

    public byte[] getSignature() {
        return signature;
    }

    public ArrayList<TransactionInput> getInputs() {
        return inputs;
    }

    public ArrayList<TransactionOutput> getOutputs() {
        return outputs;
    }

    public static int getSequence() {
        return sequence;
    }

}






























