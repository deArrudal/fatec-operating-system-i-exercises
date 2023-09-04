package controller;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLane extends Thread {
    private Random rnd = new Random();

    // thread-safe increment counter.
    private static AtomicInteger position = new AtomicInteger(1);

    private int id; // frog's id.
    private double distance; // race distance [m].
    private double maxJump; // maximum jump [m].
    private int place; // frog's position.

    public ThreadLane(int id, double distance, double maxJump) {
        this.id = id;
        this.distance = distance;
        this.maxJump = maxJump;
    }

    @Override
    public void run() {
        double currDistance = 0; // current distance.
        double jump; // frog's jump.

        while (currDistance < distance) {
            // random jump between 0 and maxJump.
            jump = rnd.nextDouble() * maxJump;

            currDistance += jump; // compute curretn distance.

            System.out.printf("Frog #%d: {Jump: %.2f m, Distance: %.2f %%}\n",
                    id, jump, 100 * (currDistance / distance));

        }

        place = position.getAndIncrement(); // get position and then increment.

        try {
            sleep(100);
            System.out.printf("Frog #%d: %d\n", id, place);

        } catch (Exception e) {
        }
    }
}
