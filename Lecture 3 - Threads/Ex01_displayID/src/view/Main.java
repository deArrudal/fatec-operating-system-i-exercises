package view;

import controller.ThreadMethod;

public class Main {
    public static void main(String[] args) {
        // creates five threads.
        for (int id = 0; id < 5; id++) {
            Thread thread = new ThreadMethod();
            thread.start();
        }
    }
}
