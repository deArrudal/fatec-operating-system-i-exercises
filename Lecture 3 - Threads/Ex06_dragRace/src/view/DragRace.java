package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.RaceThread;

public class DragRace extends JFrame implements ActionListener {
    // class' attributes.
    private JPanel racePanel;
    private final JLabel firstCar;
    private final JLabel secondCar;
    private JSeparator midLane;
    private JLabel firstLabel;
    private JLabel secondLabel;
    private JTextField firstField;
    private JTextField secondField;
    private JButton startRace;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DragRace newRace = new DragRace();
                    newRace.setVisible(true);

                } catch (Exception errMain) {
                    System.err.println(errMain);

                }
            }
        });
    }

    // draws drag race frame.
    public DragRace() {
        // frame's properties.
        setTitle("Drag Race");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setBounds(100, 100, 470, 250);
        setLocationRelativeTo(null);

        racePanel = new JPanel();
        racePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(racePanel);
        racePanel.setLayout(null);

        firstCar = new JLabel();
        firstCar.setBounds(10, 25, 30, 10);
        firstCar.setBackground(Color.blue);
        firstCar.setOpaque(true);
        racePanel.add(firstCar);

        secondCar = new JLabel();
        secondCar.setBounds(10, 55, 30, 10);
        secondCar.setBackground(Color.red);
        secondCar.setOpaque(true);
        racePanel.add(secondCar);

        midLane = new JSeparator();
        midLane.setBounds(10, 45, 430, 1);
        racePanel.add(midLane);

        firstLabel = new JLabel();
        firstLabel.setBounds(140, 90, 70, 20);
        firstLabel.setText("First Place: ");
        racePanel.add(firstLabel);

        secondLabel = new JLabel();
        secondLabel.setBounds(122, 115, 85, 20);
        secondLabel.setText("Second Place: ");
        racePanel.add(secondLabel);

        firstField = new JTextField();
        firstField.setBounds(210, 90, 100, 20);
        firstField.addActionListener(this);
        add(firstField);

        secondField = new JTextField();
        secondField.setBounds(210, 115, 100, 20);
        secondField.addActionListener(this);
        add(secondField);

        startRace = new JButton("Start");
        startRace.setBounds(170, 155, 100, 20);
        startRace.addActionListener(this);
        add(startRace);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startRace) {
            startRace.setVisible(false);

            Thread car1 = new RaceThread(firstCar, "blue",
                    midLane, firstField, secondField);

            Thread car2 = new RaceThread(secondCar, "red",
                    midLane, firstField, secondField);

            car1.start();
            car2.start();
        }
    }
}