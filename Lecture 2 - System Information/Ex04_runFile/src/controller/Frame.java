package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener {
    // variables declaration.
    JLabel labelText;
    JTextField fieldFile;
    JButton findFile;
    JButton runFile;
    JButton cancelFile;

    public Frame() {
        // JPanel's properties.
        labelText = new JLabel();
        labelText.setBounds(30, 15, 300, 20);
        labelText.setText("Enter file's path:");

        // JField's properties.
        fieldFile = new JTextField();
        fieldFile.setBounds(30, 40, 300, 20);

        // JButtons' properties
        findFile = new JButton();
        findFile.setBounds(30, 70, 90, 20);
        findFile.setText("Search");
        findFile.addActionListener(this);

        runFile = new JButton();
        runFile.setBounds(135, 70, 90, 20);
        runFile.setText("Execute");
        runFile.addActionListener(this);

        cancelFile = new JButton();
        cancelFile.setBounds(240, 70, 90, 20);
        cancelFile.setText("Cancel");
        cancelFile.addActionListener(this);

        // Frame's properties.
        this.setTitle("Run File - Windows");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(370, 150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // add elements to the frame.
        this.add(labelText);
        this.add(fieldFile);
        this.add(findFile);
        this.add(runFile);
        this.add(cancelFile);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Methods methods = new Methods();

        if (e.getSource() == findFile) {
            fieldFile.setText(methods.findFilePath());
        }

        if (e.getSource() == runFile) {
            methods.runFilePath(fieldFile.getText());
            this.dispose();
        }

        if (e.getSource() == cancelFile) {
            this.dispose();
        }
    }

}
