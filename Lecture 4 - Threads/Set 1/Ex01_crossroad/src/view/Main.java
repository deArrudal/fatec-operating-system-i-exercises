package view;

import controller.CarThread;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            Thread car = new CarThread();
            car.start();
        }
    }
}
