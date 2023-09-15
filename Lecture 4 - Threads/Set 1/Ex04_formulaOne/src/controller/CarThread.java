package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CarThread extends Thread {
    // classes
    private Random rnd = new Random();
    private static Semaphore semaphoreCircuit = new Semaphore(5);

    // race attributes.
    private int minLap = 67280; // Interlagos 1:07.28
    private int maxLap = 72140; // Interlagos Top 100.

    // scuderia and car attributes.
    private Semaphore semaphoreScuderia;
    private double[] fastLap;
    private int idCar;

    public CarThread(int idCar, Semaphore semaphoreScuderia, double[] fastLap) {
        this.idCar = idCar;
        this.semaphoreScuderia = semaphoreScuderia;
        this.fastLap = fastLap;
    }

    @Override
    public void run() {

        try {
            semaphoreScuderia.acquire(); // check if partner is racing
            semaphoreCircuit.acquire(); // check if circuit is full.
            getTime(); // compute lap time.

        } catch (Exception errSemaphore) {
            System.err.println(errSemaphore);

        } finally {
            semaphoreScuderia.release();
            semaphoreCircuit.release();
        }
    }

    private void getTime() {
        int lapTime;
        int bestTime = maxLap + 1; // default value (maxLap + 1).

        for (int i = 0; i < 3; i++) { // for each lap.
            lapTime = rnd.nextInt(maxLap - minLap) + minLap;
            System.out.printf("Car %d\tLap %d\tTime %2.5f s\n", idCar, i, ((double) lapTime) / 1000);

            if (lapTime < bestTime) { // look for best time.
                bestTime = lapTime;
            }
        }

        fastLap[idCar] = (double) bestTime / 1000;
    }
}
