package controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MethodReadFile {
    public MethodReadFile() {
        super();
    }

    // filePath = "C:\\temp" and fileName = "generic_food.csv"
    public void readFile(String path, String name) throws IOException {
        File filePath = new File(path);
        File fileName = new File(path, name);

        if (!filePath.isDirectory() || !fileName.isFile()) {
            throw new IOException("invalid inputs");
        }

        String line;
        String[] splitline = new String[4]; // FOOD NAME,SCIENTIFIC NAME,GROUP,SUB GROUP
        boolean header = true; // allow to display header.

        Scanner scan = new Scanner(fileName);

        while (scan.hasNextLine()) {
            line = scan.nextLine();
            splitline = line.split(",");

            if (splitline[2].equals("Fruits") || header) {
                System.out.printf("%25s\t%45s\t%20s\n",
                        splitline[0], splitline[1], splitline[3]);

                header = false;
            }
        }

        scan.close();
    }
}