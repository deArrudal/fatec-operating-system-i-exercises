package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ProcessThread extends Thread {
    Random rnd = new Random();
    private static Semaphore semaphoreTransaction = new Semaphore(1);

    // dataProcess = {minimum time, maximum time, transaction time, loop cycles}
    private static int[][] dataProcess = {
            { 1000, 2000, 1500, 3 }, // id % 3 == 0
            { 200, 1000, 1000, 2 }, // id % 3 == 1
            { 500, 1500, 1500, 3 } }; // id % 3 == 2

    private int idProcess;

    public ProcessThread(int idProcess) {
        this.idProcess = idProcess;
    }

    @Override
    public void run() {
        int typeProcess = idProcess % 3;
        int time;

        for (int i = 0; i < dataProcess[typeProcess][3]; i++) {
            // time = rnd.nextInt(maxTime - minTime) + minTime;
            time = rnd.nextInt(dataProcess[typeProcess][1] - dataProcess[typeProcess][0])
                    + dataProcess[typeProcess][0];
            doOperation(time, "Computation");

            time = dataProcess[typeProcess][2];
            try {
                semaphoreTransaction.acquire();
                doOperation(time, "Transaction");
            } catch (Exception errSemaphore) {
                System.err.println(errSemaphore);
            } finally {
                semaphoreTransaction.release();
            }
        }
    }

    private void doOperation(int time, String label) {
        try {
            sleep(time);
        } catch (Exception errSleep) {
            System.err.println(errSleep);
        }

        System.out.printf("Process %d\t%s\tDuration %.2f s\n",
                idProcess, label, ((double) time) / 1000);
    }
}
