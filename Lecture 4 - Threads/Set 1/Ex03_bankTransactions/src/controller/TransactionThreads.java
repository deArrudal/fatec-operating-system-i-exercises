package controller;

import java.util.concurrent.Semaphore;

public class TransactionThreads extends Thread {
    private static Semaphore withdrawSemaphore = new Semaphore(1);
    private static Semaphore depositSemaphore = new Semaphore(1);

    private int idAccount;
    private double balanceAccount;
    private int idTransaction;
    private int typeTransaction;
    private double amountTransaction;

    public TransactionThreads(int idAccount, double balanceAccount,
            int idTransaction, int typeTransaction, double amountTransaction) {
        this.idAccount = idAccount;
        this.balanceAccount = balanceAccount;
        this.idTransaction = idTransaction;
        this.typeTransaction = typeTransaction;
        this.amountTransaction = amountTransaction;
    }

    @Override
    public void run() {
        switch (typeTransaction) {
            case 0:
                try {
                    withdrawSemaphore.acquire();
                    doWithdraw();
                } catch (Exception errWithdraw) {
                    System.err.println(errWithdraw);
                } finally {
                    withdrawSemaphore.release();
                }
                break;

            case 1:
                try {
                    depositSemaphore.acquire();
                    doDeposit();
                } catch (Exception errDeposit) {
                    System.err.println(errDeposit);
                } finally {
                    depositSemaphore.release();
                }
                break;
        }
    }

    private void doWithdraw() {
        balanceAccount -= amountTransaction;
        System.out.printf("Transaction %2d\tAccount %2d\tWithdraw %4.2f\tBalance %4.2f\n",
                idTransaction, idAccount, amountTransaction, balanceAccount);
    }

    private void doDeposit() {
        balanceAccount += amountTransaction;
        System.out.printf("Transaction %2d\tAccount %2d\tDeposit %4.2f\tBalance %4.2f\n",
                idTransaction, idAccount, amountTransaction, balanceAccount);

    }

}
