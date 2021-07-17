package util;

import logic.myTextArea;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * This class is for IO operations. it handles saving and opening files.
 */

public class myFile {
    /**
     * This is for initializing buttons of our saving message
     */
    private static final String[] responses = {"Save", "Don't Save", "Cancel"};

    /**
     * This method is for saving the text of our text area into a text file at the project folder.
     * @param textArea is the text area of our editor
     * @return true if it saved successfully, and false if it failed.
     */
    public static boolean save(myTextArea textArea) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("Untitled.txt"), StandardCharsets.UTF_8))) {
            writer.write(textArea.getText());
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * This method is for opening a save dialog inorder to choose a location for saving our file
     * @param fileChooser is the file chooser of our editor
     * @param textArea is the text area of our editor
     * @return true if it saved successfully, and false if it couldn't save or the user canceled the saving operation.
     */
    public static boolean save(JFileChooser fileChooser, myTextArea textArea) {
        fileChooser = new JFileChooser(new File("."));
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file), StandardCharsets.UTF_8))) {
                writer.write(textArea.getText());
                return true;
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return false;
    }

    /**
     * This method is for opening an open dialog inorder to choose a .txt file for opening.
     * This also replaces all \n or \r characters in our text file with a new line.
     * @param textArea is the text area of our text editor
     */
    public static void open(myTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String s;
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try (Scanner input = new Scanner(file)) {
                if (file.isFile()) {
                    while (input.hasNext()) {
                        s = input.nextLine();
                        s = s.replaceAll("[{\\\\}][nr]", "\n");
                        textArea.append(s + "\n");
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static int saveWarning(myTextArea textArea) {
        int answer = JOptionPane.showOptionDialog(null, "Do you want to save changes to Untitled?",
                "Black Notepad", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, responses, 0);
        if (answer == 0)
            myFile.save(textArea);
        return answer;
    }
}
