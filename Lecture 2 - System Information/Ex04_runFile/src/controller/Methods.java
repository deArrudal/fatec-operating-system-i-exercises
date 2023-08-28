package controller;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Methods {
    public String findFilePath() {
        // set filter.
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter(
                "Executable file (.exe)", "exe");

        // set default directory.
        String defaultDir = System.getProperty("user.home") + "/Desktop";
        File fileDir = new File(defaultDir);

        // call JFileChooser and set its properties.
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(fileDir);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(fileFilter);

        String filePath = ""; // stores File Path.
        int flagPath = fileChooser.showOpenDialog(null);

        if (flagPath == JFileChooser.APPROVE_OPTION) {
            filePath = fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            JOptionPane.showMessageDialog(null, "File not found",
                    "Run File - Windows", JOptionPane.ERROR_MESSAGE);
        }

        return filePath;
    }

    public void runFilePath(String filePath) {
        try {
            String cmdExe = "cmd /c start cmd.exe /C\"" + filePath + "\"";
            Runtime.getRuntime().exec(cmdExe);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid entry",
                    "Run File - Windows", JOptionPane.ERROR_MESSAGE);
        }
    }
}
