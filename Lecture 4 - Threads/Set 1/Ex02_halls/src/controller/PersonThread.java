package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class PersonThread extends Thread {
    private static Semaphore semaphore = new Semaphore(1);
    private Random rnd = new Random();

    private int distance = 200; // [m]
    private int minSpeed = 4; // [m/s]
    private int maxSpeed = 6;
    private int minTime = 1; // [s]
    private int maxTime = 5;

    private int idPerson;
    private int distancePerson = 0;

    public PersonThread(int idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public void run() {
        walkHall();

        try {
            semaphore.acquire();
            openDoor();

        } catch (Exception errSemaphore) {
            System.err.println(errSemaphore);
        } finally {
            semaphore.release();
        }
    }

    public void walkHall() {
        while (distancePerson < distance) {
            distancePerson += rnd.nextInt(maxSpeed - minSpeed) + minSpeed;

            try {
                sleep(100); // simulate 1s of walking.
            } catch (Exception errSleepWalk) {
                System.err.println(errSleepWalk);
            }
        }

        System.out.printf("Person %d reached the door.\n", idPerson);
    }

    public void openDoor() {
        int time = rnd.nextInt(maxTime - minTime) + minTime;

        System.out.printf("Person %d is opening the door.\n", idPerson);

        try {
            sleep(time);
        } catch (Exception errSleepOpen) {
            System.err.println(errSleepOpen);
        }

        System.out.printf("Person %d opened and entered the room.\n", idPerson);
    }
}
