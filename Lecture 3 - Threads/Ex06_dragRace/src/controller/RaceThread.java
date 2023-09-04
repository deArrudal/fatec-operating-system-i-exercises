package controller;

import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceThread extends Thread {
    private Random rnd = new Random();

    // race's attributes.
    private JSeparator laneRace;
    private static AtomicInteger placeRace = new AtomicInteger(1);
    private final double distanceRace = 1000.0;
    private final double speedRace = 50.0;

    // car's attributes.
    private JLabel labelCar;
    private String colorCar;
    private int placeCar;
    private double distanceCar = 0;

    // winner's attributes.
    private JTextField firstField;
    private JTextField secondField;

    public RaceThread(JLabel labelCar, String colorCar, JSeparator laneRace,
            JTextField firstField, JTextField secondField) {
        this.labelCar = labelCar;
        this.colorCar = colorCar;
        this.laneRace = laneRace;
        this.firstField = firstField;
        this.secondField = secondField;
    }

    @Override
    public void run() {
        while (distanceCar < distanceRace) {
            try {
                sleep(100);

            } catch (Exception errSleep) {
                System.err.println(errSleep);

            }

            moveCar();
        }

        placeCar = placeRace.getAndIncrement();

        displayWinner();
    }

    public void moveCar() {
        // compute new position [x].
        distanceCar += rnd.nextDouble(speedRace);

        // corrects for overshooting.
        if (distanceCar > distanceRace) {
            distanceCar = distanceRace;

        }

        // get object's position in frame.
        Rectangle positionCar = labelCar.getBounds();
        Rectangle positionLane = laneRace.getBounds();

        // compute car's new position in frame.
        positionCar.x = positionLane.x +
                (int) ((positionLane.width - positionCar.width) *
                        (distanceCar / distanceRace));

        labelCar.setBounds(positionCar);
    }

    public synchronized void displayWinner() {
        if (placeCar == 1) {
            firstField.setText(colorCar + " car");
        } else if (placeCar == 2) {
            secondField.setText(colorCar + " car");
        }
    }
}
