package view;

import controller.PersonThread;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            Thread person = new PersonThread(i);
            person.start();
        }
    }
}