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

    // it more big, its more difficult to mine

    private static int difficulty = 5;
    private static float minimumTransaction = 0.1f;
    private static Wallet walletA;
    private static Wallet walletB;
    private static Transaction genesisTransaction;

    public void addBlock(Block newBlock) {
        newBlock.mineBlock(difficulty);
        blockchain.add(newBlock);
    }

    public boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');
        // A temporary working list of unspent transaction at a given block state
        HashMap<String, TransactionOutput> tempUTXOs = new HashMap<>(16);
        tempUTXOs.put(genesisTransaction.getOutputs().get(0).getId(), genesisTransaction.getOutputs().get(0));

        // Loop through blockchain to check hashes:
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);
            // Compare registered hash and calculated hash:
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("#Current hashes not equal");
                return false;
            }
            // Compare previous hash and registered previous hash:
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("#Previous hashes not equal");
                return false;
            }
            // Check if hash is solved
            if (!currentBlock.getHash().substring(0, difficulty).equals(hashTarget)) {
                System.out.println("#This block hasn't been mined");
                return false;
            }

            // Loop blockchain transaction
            if (loopBlockchainTransaction(currentBlock, tempUTXOs)) {
                return false;
            }
        }
        System.out.println("Blockchain is valid");
        return false;
    }

    private boolean loopBlockchainTransaction(Block currentBlock, HashMap<String, TransactionOutput> tempUTXos) {
        TransactionOutput tempOutput;
        for (int i = 0; i < currentBlock.getTransactions().size(); i++) {
            Transaction currentTransaction = currentBlock.getTransactions().get(i);
            if (!currentTransaction.verifySignature()) {
                System.out.println("#Signature on Transaction(" + i + ") is invalid");
                return true;
            }
            if (currentTransaction.getInputsValue() != currentTransaction.getOutputsValue()) {
                System.out.println("#Inputs are not equal to outputs on Transaction(" + i + ")");
                return true;
            }

            for (TransactionInput input : currentTransaction.getInputs()) {
                tempOutput = tempUTXos.get(input.getTransactionOutputId());
                if (tempOutput == null) {
                    System.out.println("#Referenced input on Transaction(" + i + ") is Missing");
                    return true;
                }
                if (input.getUtxo().getValue() != tempOutput.getValue()) {
                    System.out.println("#Referenced input Transaction(" + i + ") value is Invalid");
                    return true;
                }
                tempUTXos.remove(input.getTransactionOutputId());
            }
            for (TransactionOutput output : currentTransaction.getOutputs()) {
                tempUTXos.put(output.getId(), output);
            }

            if (currentTransaction.getOutputs().get(0).getRecipient() != currentTransaction.getRecipient()) {
                System.out.println("#Transaction(" + i + ") output recipient is not who it should be.");
                return true;
            }
            if (currentTransaction.getOutputs().get(1).getRecipient() != currentTransaction.getSender()) {
                System.out.println("#Transaction(" + i + ") output 'change' is not sender.");
                return true;
            }
        }
        return false;
    }

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

    public void setWalletA(Wallet walletA) {
        NoobChain.walletA = walletA;
    }

    public Wallet getWalletB() {
        return walletB;
    }

    public void setWalletB(Wallet walletB) {
        NoobChain.walletB = walletB;
    }

    public Transaction getGenesisTransaction() {
        return genesisTransaction;
    }

    public void setGenesisTransaction(Transaction genesisTransaction) {
        NoobChain.genesisTransaction = genesisTransaction;
    }

}
