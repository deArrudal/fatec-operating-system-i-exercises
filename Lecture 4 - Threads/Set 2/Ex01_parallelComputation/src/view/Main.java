package view;

import controller.ProcessThread;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 21; i++) {
            Thread prc = new ProcessThread(i);
            prc.start();
        }
    }
}