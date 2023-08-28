package controller;

import java.util.Scanner;

public class TaskMethods {
    public TaskMethods() {
        super();
    }

    private String readOS() {
        String os = System.getProperty("os.name");
        return os;
    }

    public void displayTask() {
        String os = readOS();
        String callTask = "TASKLIST /FO TABLE";
        String tmpLine;

        if (os.contains("Linux")) {
            callTask = "ps -ef";
        }

        try {
            Process process = Runtime.getRuntime().exec(callTask);
            Scanner scanProcess = new Scanner(process.getInputStream());

            while (scanProcess.hasNextLine()) {
                tmpLine = scanProcess.nextLine();
                System.out.println(tmpLine);
            }

            scanProcess.close();
            System.out.println();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void killTaskPID(String taskPID) {
        String os = readOS();
        String cmdTask = "TASKKILL /PID " + taskPID; // set Windows as default.

        if (os.contains("Linux")) {
            cmdTask = "kill -9 " + taskPID;
        }

        try {
            Runtime.getRuntime().exec(cmdTask);
            System.out.println("Task killed successful");

        } catch (Exception e) {
            System.err.println(e);
        }

        System.out.println();
    }

    public void killTaskName(String taskName) {
        String os = readOS();
        String cmdTask = "TASKKILL /IM " + taskName;

        if (os.contains("Linux")) {
            cmdTask = "pkill -f " + taskName;
        }

        try {
            Runtime.getRuntime().exec(cmdTask);
            System.out.println("Task killed successful");

        } catch (Exception e) {
            System.err.println(e);
        }

        System.out.println();
    }
}
