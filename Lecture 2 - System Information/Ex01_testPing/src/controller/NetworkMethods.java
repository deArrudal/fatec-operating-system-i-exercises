package controller;

import java.util.Scanner;

public class NetworkMethods {
    public NetworkMethods() {
        super();
    }

    private String readOS() {
        String os = System.getProperty("os.name");
        return os;
    }

    public void readIP() {
        String os = readOS();
        String callIP = "ipconfig /all"; // set Windows as default.
        String tmpLine;
        String deviceName = "";
        String deviceIPV4 = "";

        if (os.contains("Linux")) {
            callIP = "ip addr";
        }

        try {
            Process process = Runtime.getRuntime().exec(callIP);
            Scanner scanProcess = new Scanner(process.getInputStream());

            while (scanProcess.hasNextLine()) {
                tmpLine = scanProcess.nextLine();

                if (tmpLine != "") {
                    if (!tmpLine.contains("  ")) { // look for device name.
                        if (os.contains("Windows")) {
                            deviceName = tmpLine.split(":")[0];

                        } else if (os.contains("Linux")) {
                            deviceName = tmpLine.split(":")[1].trim();
                        }

                    } else if (tmpLine.contains("IPv4") || tmpLine.contains("inet ")) { // look for IPv4.
                        if (os.contains("Windows")) {
                            tmpLine = tmpLine.split(": ")[1];
                            deviceIPV4 = tmpLine.split("\\(")[0];

                        } else if (os.contains("Linux")) {
                            tmpLine = tmpLine.trim();
                            tmpLine = tmpLine.split(" ")[1];
                            deviceIPV4 = tmpLine.split("/")[0];
                        }

                        if (deviceIPV4 != "") { // if IPv4 not-null, display.
                            System.out.println(deviceName + ": " + deviceIPV4);
                        }
                    }
                }
            }

            scanProcess.close();
            System.out.println();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void sendPing(String sitePing) {
        String os = readOS();
        String callPing = "ping -4 -n 10 " + sitePing; // set Windows as default.
        String tmpLine;
        String pingInfo = "";
        String pingData = "";

        if (os.contains("Linux")) {
            callPing = "ping -4 -c 10 " + sitePing;
        }

        try {
            Process process = Runtime.getRuntime().exec(callPing);
            Scanner scanProcess = new Scanner(process.getInputStream());

            System.out.println("Sending request, please wait a moment");

            while (scanProcess.hasNextLine()) {
                tmpLine = scanProcess.nextLine();
                System.out.print("-");

                if (tmpLine != "") {
                    if (tmpLine.contains("Pinging") || tmpLine.contains("PING")) {
                        if(os.contains("Windows")) {
                            pingInfo = tmpLine.split(":")[0];
                        } else if(os.contains("Linux")) {
                            pingInfo = tmpLine;
                        }
                    } else if (tmpLine.contains("Average") || tmpLine.contains("avg")) {
                        if(os.contains("Windows")) {
                            pingData = tmpLine.split(" = ")[3];
                        } else if(os.contains("Linux")) {
                            pingData = tmpLine.split("/")[4] + "ms";
                        }
                    }
                }
            }

            scanProcess.close();
            System.out.println("\n" + pingInfo + " -> Average = " + pingData);
            System.out.println();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
