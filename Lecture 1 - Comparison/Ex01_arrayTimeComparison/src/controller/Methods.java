package controller;

public class Methods {
    public Methods() {
        super();
    }

    // display the time to cover all elements in an array.
    public void arrayTime(int[] array) {
        double initial_time = System.nanoTime();

        for (int element : array) { // run through array.
            // Stub.
        }

        // compute total time [s].
        double time = (System.nanoTime() - initial_time) / Math.pow(10, 9);

        System.out.printf("Elements: %6d\tTime: %f\n", array.length, time);
    }
}