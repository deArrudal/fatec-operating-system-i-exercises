package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DishThread extends Thread {
    private Random rnd = new Random();
    private static Semaphore semaphoreDelivery = new Semaphore(1);

    private String[] nameDish = { "Lasagna", "Onion Soup" };

    private int[][] propertiesDish = {
            { 600, 1200 }, // lasagna.
            { 500, 800 } // onion soup.
    };

    private int idDish;

    public DishThread(int idDish) {
        this.idDish = idDish;
    }

    @Override
    public void run() {
        int typeDish = idDish % 2;

        makeDish(typeDish);

        try {
            semaphoreDelivery.acquire();
            deliverDish(typeDish);

        } catch (Exception errSemaphore) {
            System.err.println(errSemaphore);

        } finally {
            semaphoreDelivery.release();
        }
    }

    private void makeDish(int typeDish) {
        int timeDish = rnd.nextInt(propertiesDish[typeDish][1] - propertiesDish[typeDish][0])
                + propertiesDish[typeDish][0];

        int time = 0;

        System.out.printf("Making %s\n", nameDish[typeDish]);

        while (time < timeDish) {
            System.out.printf("%10s\t%d%%\n",
                    nameDish[typeDish], (int) (100 * (((double) time) / timeDish)));

            try {
                sleep(100);

            } catch (Exception errSleep) {
                System.err.println(errSleep);
            }

            time += 100;
            time = (time >= timeDish) ? timeDish : time; // fix time.
        }
    }

    private void deliverDish(int typeDish) {
        try {
            sleep(500);
        } catch (Exception errSleep) {
            System.err.println(errSleep);
        }

        System.out.printf("%s is ready\n", nameDish[typeDish]);
    }
}