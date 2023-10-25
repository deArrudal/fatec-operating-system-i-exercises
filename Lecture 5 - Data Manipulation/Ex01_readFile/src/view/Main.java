package view;

import java.io.IOException;
import controller.MethodReadFile;

public class Main {
    public static void main(String[] args) {
        MethodReadFile method = new MethodReadFile();
        String filePath = "C:\\temp";
        String fileName = "generic_food.csv";

        try {
            method.readFile(filePath, fileName);
        } catch (IOException errRead) {
            System.err.println(errRead);
        }
    }
}
