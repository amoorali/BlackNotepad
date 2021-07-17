package logic.menuBar;

import logic.myTextArea;

import javax.swing.*;
import java.awt.*;

/**
 * This class is the menubar of the text editor
 */
public class myMenuBar extends JMenuBar {

    /**
     * this constructor initializes the properties of the menu bar and adds menus to it.
     * @param textArea is the text area of our text editor
     */
    public myMenuBar(myTextArea textArea) {
        FileMenu fileMenu = new FileMenu(textArea);
        EditMenu editMenu = new EditMenu(textArea);
        FormatMenu formatMenu = new FormatMenu(textArea);

        this.setBackground(Color.ORANGE);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        this.add(fileMenu);
        this.add(editMenu);
        this.add(formatMenu);
    }

}
