package controller;

import java.util.Scanner;

public class OSMethods {
    public OSMethods() {
        super();
    }

    private String readOS() {
        String os = System.getProperty("os.name");
        return os;
    }

    public void distroProperties() {
        String os = readOS();
        String cmdDistro = "cat /etc/os-release";

        if (os.contains("Linux")) {
            try {
                Process process = Runtime.getRuntime().exec(cmdDistro);
                Scanner scan = new Scanner(process.getInputStream());

                while (scan.hasNextLine()) {
                    System.out.println(scan.nextLine());
                }
            } catch (Exception e) {
                System.err.println(e);
            }

        } else {
            System.out.println("Current system isn't Linux");
        }
    }
}
