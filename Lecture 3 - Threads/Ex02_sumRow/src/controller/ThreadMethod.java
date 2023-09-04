package controller;

public class ThreadMethod extends Thread {
    private int id;
    private int[] array;
    private int sum = 0;

    public ThreadMethod(int id, int[] array) {
        this.id = id;
        this.array = array;
    }

    @Override
    public void run() {
        for (int i : array) {
            sum += i;
        }
        System.out.printf("row %d: %d\n", id, sum);
    }
}