package view;

import java.util.Scanner;
import controller.NetworkMethods;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        NetworkMethods methods = new NetworkMethods();
        
        String prompt;
        String sitePing = "www.google.com.br";
        int option;

        prompt = "1.Display IP\t2.Send Ping\t"
                + "9.Quit"
                + "\nEnter option: ";

        do {
            System.out.print(prompt);
            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    System.out.println("=> Display IP");
                    methods.readIP();
                    break;
                case 2:
                    System.out.println("=> Send Ping");
                    methods.sendPing(sitePing);
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