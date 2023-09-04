package controller;

import java.util.Scanner;

public class PingThread extends Thread {
    private String name;
    private String site;

    public PingThread(String name, String site) {
        this.name = name;
        this.site = site;
    }

    @Override
    public void run() {
        String callPing = "ping -4 -c 10 " + site; // set command.
        String tmpLine;
        String outLine = "";

        try {
            Process process = Runtime.getRuntime().exec(callPing);
            Scanner scanProcess = new Scanner(process.getInputStream());

            while (scanProcess.hasNextLine()) {
                tmpLine = scanProcess.nextLine();

                if (!tmpLine.isEmpty()) {
                    if (tmpLine.contains("time=")) {
                        System.out.printf("%s: time = %s\n", name, tmpLine.split("=")[3]);

                    } else if (tmpLine.contains("avg")) {
                        outLine = name + ": avg = " + tmpLine.split("/")[4] + "ms";

                    }
                }
            }

            scanProcess.close();

            try {
                sleep(1000);
            } catch (Exception e) {
            }

            System.out.printf("%s\n", outLine);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}