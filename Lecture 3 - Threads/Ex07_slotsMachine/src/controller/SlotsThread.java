package controller;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.util.Random;

public class SlotsThread extends Thread {
    private Random rnd = new Random();
    Font font = new Font("Arial", Font.BOLD, 50);

    // slot's attributes.
    private JTextField slot;
    private int maxTime = 150;
    private int minTime = 60;
    private int maxValue = 7;
    private int minValue = 1;

    public SlotsThread(JTextField slot) {
        this.slot = slot;
    }

    @Override
    public void run() {
        int ntimes = minTime + rnd.nextInt((maxTime - minTime) + 1);
        int numValue;

        for (int i = 0; i < ntimes; i++) {
            try {
                sleep(1000 / ntimes);
            } catch (Exception errSleep) {
                System.out.println(errSleep);
            }

            numValue = minValue + rnd.nextInt((maxValue - minValue) + 1);

            slot.setText(Integer.toString(numValue));
            slot.setHorizontalAlignment(SwingConstants.CENTER);
            slot.setFont(font);
        }
    }
}
