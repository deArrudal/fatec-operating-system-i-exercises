package view;

import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

import controller.CarThread;

public class Main {
    static Semaphore[] semaphoreScuderias = new Semaphore[7];
    static double[] fastLap = new double[14];

    public static void main(String[] args) {
        Thread[] cars = new CarThread[14];
        int idCar = 0;

        // start threads.
        for (int i = 0; i < 7; i++) { // loop through all scuderias.
            semaphoreScuderias[i] = new Semaphore(1); // allow 1 car for each scuderia.

            for (int j = 0; j < 2; j++) { // loop through cars in same scuderia.
                cars[idCar] = new CarThread(idCar, semaphoreScuderias[i], fastLap);
                cars[idCar].start();
                idCar++;
            }

        }

        // wait all threads to conclude.
        for (Thread car : cars) {
            try {
                car.join();
            } catch (Exception errJoin) {
                System.err.println(errJoin);
            }
        }

        // sort and display grid.
        int[] grid = IntStream.range(0, fastLap.length)
                .boxed().sorted((i, j) -> Double.compare(fastLap[i], fastLap[j]))
                .mapToInt(ele -> ele).toArray();

        System.out.println("Grid:");
        System.out.println(Arrays.toString(grid));
        // System.out.println(Arrays.toString(fastLap));
    }
}