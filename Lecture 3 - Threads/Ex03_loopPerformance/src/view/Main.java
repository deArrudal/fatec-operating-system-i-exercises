package view;

import java.util.Random;
import controller.ThreadMethods;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        int size = 1000;
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = rnd.nextInt(101); 
        }
        
        for(int i = 0; i < 2; i++) {
            Thread thread = new ThreadMethods(i + 1, array);
            thread.start();
        }
    }    
}
