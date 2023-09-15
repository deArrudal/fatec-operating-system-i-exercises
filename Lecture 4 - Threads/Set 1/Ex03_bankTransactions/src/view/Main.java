package view;

import java.util.Random;

import controller.TransactionThreads;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();

        int idAccount;
        double balanceAccount;
        int typeTransaction;
        double amountTransaction;

        for (int i = 0; i < 20; i++) {
            idAccount = rnd.nextInt(5); // account id.
            balanceAccount = rnd.nextDouble() * 4000 + 1000;
            typeTransaction = rnd.nextInt(2); // transaction type.
            amountTransaction = rnd.nextDouble() * 100; // transaction value.

            Thread transaction = new TransactionThreads(idAccount, balanceAccount,
                    i, typeTransaction, amountTransaction);
            transaction.start();
        }
    }
}