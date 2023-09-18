package view;

import controller.DishThread;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread dish = new DishThread(i);
            dish.start();
        }

    }
}
