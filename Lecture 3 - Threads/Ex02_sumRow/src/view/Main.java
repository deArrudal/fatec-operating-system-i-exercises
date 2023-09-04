package view;

import java.util.Arrays;
import java.util.Random;

import controller.ThreadMethod;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[][] array = new int[3][5];
        int rsize = array.length;
        int csize = array[0].length;

        System.out.println("Array:");
        for (int i = 0; i < rsize; i++) {
            for (int j = 0; j < csize; j++) {
                array[i][j] = rnd.nextInt(10);
            }
            System.out.println(Arrays.toString(array[i]));
        }

        System.out.println("Sum row:");
        for (int i = 0; i < rsize; i++) {
            Thread tread = new ThreadMethod(i, array[i]);
            tread.start();
        }
    }
}
