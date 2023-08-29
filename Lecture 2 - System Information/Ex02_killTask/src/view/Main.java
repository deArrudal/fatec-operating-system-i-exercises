package view;

import java.util.Scanner;
import controller.TaskMethods;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TaskMethods methods = new TaskMethods();

        String prompt;
        String taskId;
        int option;

        prompt = "1.Task list\t2.Kill task by PID\t"
                + "3.Kill task by Name\t9.Quit"
                + "\nEnter option: ";

        do {
            System.out.print(prompt);
            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    System.out.println("=> Task List");
                    methods.displayTask();
                    break;
                case 2:
                    System.out.println("=> Kill task by PID");
                    System.out.print("Enter PID: ");
                    taskId = scan.nextLine();
                    methods.killTaskPID(taskId);
                    break;
                case 3:
                    System.out.println("=> Kill task by Name");
                    System.out.print("Enter Name: ");
                    taskId = scan.nextLine();
                    methods.killTaskName(taskId);
                    break;
                case 9:
                    System.out.println("=> Quit");
                    break;
                default:
                    System.out.println("=> Invalid option");
                    System.out.println();
            }
            
        } while (option != 9);

        scan.close();
    }
}