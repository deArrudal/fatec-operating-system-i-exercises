package view;

import controller.Methods;

public class Main {
    public static void main(String[] args) {
        Methods methods = new Methods();
        int[] array0 = new int[1000];
        int[] array1 = new int[10000];
        int[] array2 = new int[100000];

        methods.arrayTime(array0);
        methods.arrayTime(array1);
        methods.arrayTime(array2);
    }    
}
