package controller;

public class ThreadMethods extends Thread {
    private int type;
    private int[] array;

    public ThreadMethods(int type, int[] array) {
        this.type = type;
        this.array = array;
    }

    @Override
    public void run() {
        double t0, t1, time;

        if (type % 2 == 0) {
            t0 = System.nanoTime();

            for (int i = 0; i < array.length; i++) {
            }

            t1 = System.nanoTime();

        } else {
            t0 = System.nanoTime();

            for (int i : array) {
            }

            t1 = System.nanoTime();
        }

        time = (t1 - t0) / Math.pow(10, 9);
        System.out.printf("%d: %f s\n", type, time);
    }
}