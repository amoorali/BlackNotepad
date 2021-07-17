package logic.menuBar;

import logic.*;
import resources.ImageCreator;
import util.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the File menu of the text editor. it handles saving files, opening new files and windows.
 * All the actions about I/O files are handled in this class.
 */

public class FileMenu extends JMenu implements ActionListener {
    /**
     * The menu item of File menu that does what its name suggests.
     */
    JMenuItem newFile = new JMenuItem("New File"),
            newWindow = new JMenuItem("New Window"),
            openFile = new JMenuItem("Open"),
            saveFile = new JMenuItem("Save"),
            saveAsFile = new JMenuItem("Save As"),
            exitFile = new JMenuItem("Exit");

    private int response;

    JFileChooser fileChooser;
    myTextArea textArea;

    /**
     * This constructor initializes the properties of the File menu of the text editor.
     * It sets action listeners, action commands, and accelerators and also adds menu items to our file menu.
     * @param textArea is the text area of our text editor
     */
    public FileMenu(myTextArea textArea) {
        this.setText("File");
        this.textArea = textArea;

        // *-------Add Image Icon-------*
        newFile.setIcon(ImageCreator.getInstance().getNewFileIcon());
        newWindow.setIcon(ImageCreator.getInstance().getNewWindowIcon());
        openFile.setIcon(ImageCreator.getInstance().getOpenIcon());
        saveFile.setIcon(ImageCreator.getInstance().getSaveIcon());
        saveAsFile.setIcon(ImageCreator.getInstance().getSaveIcon());
        // *-------/Add Image Icon-------*


        // *-------Add Action Listener-------*
        newFile.addActionListener(this);
        newWindow.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        saveAsFile.addActionListener(this);
        exitFile.addActionListener(this);
        // *-------/Add Action Listener-------*


        // *-------Set Action Command-------*
        Shortcuts.setActionCommand(newFile);
        Shortcuts.setActionCommand(newWindow);
        Shortcuts.setActionCommand(openFile);
        Shortcuts.setActionCommand(saveFile);
        Shortcuts.setActionCommand(saveAsFile);
        Shortcuts.setActionCommand(exitFile);
        // *-------/Set Action Command-------*


        // *-------Set Accelerator-------*
        Shortcuts.setAccelerator(newFile);
        Shortcuts.setAccelerator(newWindow);
        Shortcuts.setAccelerator(openFile);
        Shortcuts.setAccelerator(saveFile);
        Shortcuts.setAccelerator(saveAsFile);
        // *-------/Set Accelerator-------*


        // *-------File Menu Completion-------*
        this.add(newFile);
        this.add(newWindow);
        this.addSeparator();

        this.add(openFile);
        this.add(saveFile);
        this.add(saveAsFile);
        this.addSeparator();

        this.add(exitFile);
        // *-------/File Menu Completion-------*

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New File" -> {
                if (this.textArea.saveStatus)
                    response = myFile.saveWarning(this.textArea);

                if (response != 2)
                    this.textArea.setText("");
            }
            case "New Window" -> new TextEditor(this.textArea.getXPosition() + 30, this.textArea.getYPosition() + 30);
            case "Open" -> myFile.open(this.textArea);
            case "Save" -> this.textArea.saveStatus = myFile.save(this.textArea);
            case "Save As" -> this.textArea.saveStatus = myFile.save(this.fileChooser, this.textArea);
            case "Exit" -> {
                if(this.textArea.saveStatus)
                    response = myFile.saveWarning(this.textArea);

                if (response != 2)
                    System.exit(0);
            }
        }
    }
}
