package com.hnq.study.blockchain;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.HashMap;

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
//        NoobChain
        return 0L;
    }

}
