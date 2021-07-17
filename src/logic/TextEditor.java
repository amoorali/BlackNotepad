package logic;

import javax.swing.*;
import java.awt.*;

import logic.menuBar.myMenuBar;
import resources.ImageCreator;

/**
* This class is the base of the text editor which is the JFrame and it creates JMenuBar and JTextArea
* */
public class TextEditor extends JFrame {
    myMenuBar menuBar;
    myTextArea textArea;

    /**
     * this constructor receives parameters to open new windows in new locations.
     * @param x is the length of our frame
     * @param y is the height of our frame
     */
    public TextEditor(int x, int y) {
        this.setIconImage(ImageCreator.getInstance().getAppIcon().getImage());

        this.setTitle("Black Notepad");
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(new GridLayout());

        this.textArea = new myTextArea();
        this.textArea.setXPosition(x);
        this.textArea.setYPosition(y);
        this.add(this.textArea.scrollPane);

        this.menuBar = new myMenuBar(this.textArea);
        this.setJMenuBar(this.menuBar);

        this.setLocation(x,y);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
