package com.hnq.study;

import com.hnq.study.blockchain.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

/**
 * @author henengqiang
 * @date 2018/8/23
 */
public class BlockchainTests {

    public static void main(String[] args) {
        createBlockTest();
        System.out.println("//----------------------------------------------------------------------//");

        // Add our blocks to the blockchain ArrayList
        // Setup Bouncy castle as a Security Provider
        Security.addProvider(new BouncyCastleProvider());

        // Create wallets
        NoobChain noobChain = new NoobChain();
        noobChain.setWalletA(new Wallet());
        noobChain.setWalletB(new Wallet());
        Wallet coinBase = new Wallet();

        // Create genesis transaction, which sends 100 NoobCoin to WalletA
        noobChain.setGenesisTransaction(new Transaction(coinBase.getPublicKey(), noobChain.getWalletA().getPublicKey(), 100F, null));
        // Manually sign the genesis transaction
        noobChain.getGenesisTransaction().generateSignature(coinBase.getPrivateKey());
        // Manually set the transaction id
        noobChain.getGenesisTransaction().setTransactionId("0");
        // Manually add the Transaction Output
        noobChain.getGenesisTransaction().getOutputs().add(new TransactionOutput(
                noobChain.getGenesisTransaction().getRecipient(),
                noobChain.getGenesisTransaction().getValue(),
                noobChain.getGenesisTransaction().getTransactionId()));
        // Its important to store our first transaction in the UTXOs list
        noobChain.getUtxos().put(noobChain.getGenesisTransaction().getOutputs().get(0).getId(), noobChain.getGenesisTransaction().getOutputs().get(0));

        System.out.println("Creating and Mining Genesis block...");
        Block genesis = new Block("0");
        genesis.addTransaction(noobChain.getGenesisTransaction());
        noobChain.addBlock(genesis);

        allTest(genesis);
    }

    private static void createBlockTest() {
        Block genesisBlock = new Block("0", "Hi im the first block");
        System.out.println("Hash for block 1: " + genesisBlock.getHash());
        Block secondBlock = new Block(genesisBlock.getHash(), "Hi im the second block");
        System.out.println("Hash for block 2: " + secondBlock.getHash());
        Block thirdBlock = new Block(secondBlock.getHash(), "Hi im the third block");
        System.out.println("Hash for block 3: " + thirdBlock.getHash());
    }

    private static void allTest(Block genesis) {
        Block block1 = new Block(genesis.getHash());
        NoobChain noobChain = new NoobChain();
        System.out.println("\nWalletA's balance is: " + noobChain.getWalletA().getBalance());
        System.out.println("\nWalletA is attempting to send funds (40) to WalletB...");
        block1.addTransaction(noobChain.getWalletA().sendFunds(noobChain.getWalletB().getPublicKey(), 40F));
        noobChain.addBlock(block1);
        System.out.println("\nWalletA's balance is: " + noobChain.getWalletA().getBalance());
        System.out.println("WalletB's balance is: " + noobChain.getWalletB().getBalance());

        Block block2 = new Block(block1.getHash());
        System.out.println("\nWalletA attempting to send more funds (1000) than it has...");
        block2.addTransaction(noobChain.getWalletA().sendFunds(noobChain.getWalletB().getPublicKey(), 1000F));
        noobChain.addBlock(block2);
        System.out.println("\nWalletA's balance is: " + noobChain.getWalletA().getBalance());
        System.out.println("WalletB's balance is: " + noobChain.getWalletB().getBalance());

        Block block3 = new Block(block2.getHash());
        System.out.println("\nWalletB is attempting to send funds (20) to WalletA...");
        block3.addTransaction(noobChain.getWalletB().sendFunds(noobChain.getWalletA().getPublicKey(), 20F));
        System.out.println("\nWalletA's balance is: " + noobChain.getWalletA().getBalance());
        System.out.println("WalletB's balance is: " + noobChain.getWalletB().getBalance());

        noobChain.isChainValid();
    }

}
