package controller;

import java.util.concurrent.atomic.AtomicInteger;

public class CarThread extends Thread {
    private static AtomicInteger idCar = new AtomicInteger(0);
    private String[] directions = { "north", "west", "east", "south" };

    public CarThread() {
        super();
    }

    @Override
    public void run() {
        int car = idCar.getAndIncrement();
        System.out.printf("Car %d crossed to %s\n", car + 1, directions[car]);
    }
}