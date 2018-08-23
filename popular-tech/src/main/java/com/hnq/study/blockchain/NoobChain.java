package com.hnq.study.blockchain;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author henengqiang
 * @date 2018/8/22
 */
public class NoobChain {

    private static ArrayList<Block> blockchain = new ArrayList<>();
    private static HashMap<String, TransactionOutput> utxos = new HashMap<>();

    private static int difficulty = 3;
    private static float minimumTransaction = 0.1f;
    private static Wallet walletA;
    private static Wallet walletB;
    private static Transaction genesisTransaction;







    public ArrayList<Block> getBlockchain() {
        return blockchain;
    }

    public HashMap<String, TransactionOutput> getUtxos() {
        return utxos;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public float getMinimumTransaction() {
        return minimumTransaction;
    }

    public Wallet getWalletA() {
        return walletA;
    }

    public Wallet getWalletB() {
        return walletB;
    }

    public Transaction getGenesisTransaction() {
        return genesisTransaction;
    }

}
