package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.SlotsThread;

public class SlotsMachine extends JFrame implements ActionListener {
    // class' attributes.
    private JPanel slotsPanel;
    private JTextField firstField;
    private JTextField secondField;
    private JTextField thirdField;
    private JButton startSlots;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SlotsMachine newRace = new SlotsMachine();
                    newRace.setVisible(true);

                } catch (Exception errMain) {
                    System.err.println(errMain);

                }
            }
        });
    }

    // draws slots machine frame.
    public SlotsMachine() {
        // frame's properties.
        setTitle("Slots Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setBounds(100, 100, 350, 240);
        setLocationRelativeTo(null);

        slotsPanel = new JPanel();
        slotsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(slotsPanel);
        slotsPanel.setLayout(null);

        firstField = new JTextField();
        firstField.setBounds(60, 40, 60, 80);
        firstField.addActionListener(this);
        slotsPanel.add(firstField);

        secondField = new JTextField();
        secondField.setBounds(140, 40, 60, 80);
        secondField.addActionListener(this);
        slotsPanel.add(secondField);

        thirdField = new JTextField();
        thirdField.setBounds(220, 40, 60, 80);
        thirdField.addActionListener(this);
        slotsPanel.add(thirdField);

        startSlots = new JButton("Start");
        startSlots.setBounds(115, 150, 100, 20);
        startSlots.addActionListener(this);
        add(startSlots);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startSlots) {
            startSlots.setVisible(false);

            Thread window1 = new SlotsThread(firstField);
            Thread window2 = new SlotsThread(secondField);
            Thread window3 = new SlotsThread(thirdField);

            window1.start();
            window2.start();
            window3.start();
        }
    }
}