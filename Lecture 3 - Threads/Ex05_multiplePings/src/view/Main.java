package view;

import controller.PingThread;

public class Main {
    public static void main(String[] args) {
        // check operational system.
        String os = System.getProperty("os.name");
        if (!os.contains("Linux")) {
            System.out.println("Invalid Operational System");
            System.exit(0);
        }

        // build list of sites following the format {name, site}.
        String[][] sitesPing = {
                { "UOL", "www.uol.com.br" },
                { "Terra", "www.terra.com.br" },
                { "Google", "www.google.com.br" } };
        int size = sitesPing.length;

        for (int i = 0; i < size; i++) {
            Thread thread = new PingThread(sitesPing[i][0], sitesPing[i][1]);
            thread.start();
        }
    }
}
