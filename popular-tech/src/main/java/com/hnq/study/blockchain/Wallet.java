package com.hnq.study.blockchain;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author henengqiang
 * @date 2018/8/22
 */
public class Wallet {

    // 私钥用来签署我们不想被篡改的数据，公钥用来验证签名

    /**
     * 私钥是我们签署交易的密钥，要对其他人保密
     */
    private PrivateKey privateKey;

    /**
     * 公钥作为我们在区块链上的地址，可以提供给别人
     */
    private PublicKey publicKey;

    private HashMap<String, TransactionOutput> utxos = new HashMap<>();

    public Wallet() {
        generateKeyPair();
    }

    private void generateKeyPair() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            // Initialize the key generator and generate a keyPair
            keyGen.initialize(ecSpec, random);
            KeyPair keyPair = keyGen.generateKeyPair();
            // Set the public and private keys from the keyPair
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public float getBalance() {
        float total = 0;
        NoobChain noobChain = new NoobChain();
        for (Map.Entry<String, TransactionOutput> item : noobChain.getUtxos().entrySet()) {
            TransactionOutput UTXO = item.getValue();
            // If output belongs to me (if coins belong to me)
            if (UTXO.isMine(publicKey)) {
                // Add it to our list of unspent transaction
                utxos.put(UTXO.getId(), UTXO);
                total += UTXO.getValue();
            }
        }
        return total;
    }
    
    public Transaction sendFunds(PublicKey recipient, float value) {
        if (getBalance() < value) {
            System.out.println("#Not Enough funds to send transaction. Transaction Discarded.");
            return null;
        }
        ArrayList<TransactionInput> inputs = new ArrayList<>();
        float total = 0;
        for (Map.Entry<String, TransactionOutput> item : utxos.entrySet()) {
            TransactionOutput UTXO = item.getValue();
            total += UTXO.getValue();
            inputs.add(new TransactionInput(UTXO.getId()));
            if (total > value) {
                break;
            }
        }
        Transaction newTransaction = new Transaction(publicKey, recipient, value, inputs);
        newTransaction.generateSignature(privateKey);
        for (TransactionInput input : inputs) {
            utxos.remove(input.getTransactionOutputId());
        }
        return newTransaction;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public HashMap<String, TransactionOutput> getUtxos() {
        return utxos;
    }

}
