package logic.menuBar;

import logic.myTextArea;
import util.Shortcuts;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the Edit menu of the text editor. it handles undo, redo, cut, copy, paste, and select all.
 * All the actions about editing or changing status of the text of our text area is handled in this class.
 */
public class EditMenu extends JMenu implements ActionListener {
    /**
     * The menu item of Editor menu that does what its name suggests
     */
    JMenuItem undo = new JMenuItem("Undo"),
            redo = new JMenuItem("Redo"),
            cut = new JMenuItem("Cut"),
            copy = new JMenuItem("Copy"),
            paste = new JMenuItem("Paste"),
            delete = new JMenuItem("Delete"),
            selectAll = new JMenuItem("Select All");

    UndoManager undoManager = new UndoManager();
    Document document;
    myTextArea textArea;

    /**
     * This constructor initializes the properties of the Edit menu of the text editor.
     * It sets action listeners, action commands, and accelerators and also adds menu items to our edit menu.
     * @param textArea is the text area of our text editor
     */
    public EditMenu(myTextArea textArea) {
        this.setText("Edit");
        this.textArea = textArea;
        this.textArea.getDocument().addUndoableEditListener(e -> undoManager.addEdit(e.getEdit()));


        // *-------Add Action Listener-------*
        undo.addActionListener(this);
        redo.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        delete.addActionListener(this);
        selectAll.addActionListener(this);
        // *-------/Add Action Listeners-------*


        // *-------Set Action Command-------*
        Shortcuts.setActionCommand(undo);
        Shortcuts.setActionCommand(redo);
        Shortcuts.setActionCommand(cut);
        Shortcuts.setActionCommand(copy);
        Shortcuts.setActionCommand(paste);
        Shortcuts.setActionCommand(delete);
        Shortcuts.setActionCommand(selectAll);
        // *-------/Set Action Command-------*


        // *-------Set Accelerator-------*
        undo.setAccelerator(Shortcuts.getShortcut(undo));
        redo.setAccelerator(Shortcuts.getShortcut(redo));
        cut.setAccelerator(Shortcuts.getShortcut(cut));
        copy.setAccelerator(Shortcuts.getShortcut(copy));
        paste.setAccelerator(Shortcuts.getShortcut(paste));
        delete.setAccelerator(Shortcuts.getShortcut(delete));
        selectAll.setAccelerator(Shortcuts.getShortcut(selectAll));
        // *-------/Set Accelerator-------*


        // *-------Edit Menu Completion-------*
        this.add(undo);
        this.add(redo);
        this.addSeparator();

        this.add(cut);
        this.add(copy);
        this.add(paste);
        this.add(delete);
        this.addSeparator();

        this.add(selectAll);
        // *-------/Edit Menu Completion-------*
    }

    /**
     * Deletes the selected text.
     * If no text is selected, the character before the cursor gets deleted when called.
     * @throws BadLocationException when attempts to reference a location that doesn't exist
     */
    private void deleteText() throws BadLocationException {
        if (this.textArea.getSelectedText() == null && this.textArea.getText() != null) {
            document = textArea.getDocument();
            document.remove(document.getLength() - 1, 1);
        } else {
            this.textArea.setText(this.textArea.getText().replace(textArea.getSelectedText(), ""));
        }
    }

    /**
     * This method handles the cut, copy, and paste actions of the text editor.
     */
    private void documentManager() {
        this.textArea.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                textArea.saveStatus = false;
            }

            public void insertUpdate(DocumentEvent e) {
                System.out.println("insertUpdate: Added " + e.getLength() +
                        " characters, document length = " + e.getDocument().getLength());
                textArea.saveStatus = false;
            }

            public void removeUpdate(DocumentEvent e) {
                System.out.println("removeUpdate: Removed " + e.getLength() +
                        " characters, document length = " + e.getDocument().getLength());
                textArea.saveStatus = false;
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Undo" -> undoManager.undo();
            case "Redo" -> undoManager.redo();
            case "Cut", "Copy", "Paste" -> documentManager();
            case "Delete" -> {
                try {
                    deleteText();
                } catch (BadLocationException badLocationException) {
                    System.out.println(badLocationException.getMessage());
                }
            }
            case "Select All" -> this.textArea.selectAll();
        }
    }
}
