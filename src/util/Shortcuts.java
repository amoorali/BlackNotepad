package util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * This class holds keystrokes, and it simplifies setting accelerators and action commands for menu items.
 */
public class Shortcuts {

    /**
     * This method returns a keystroke based on the name of the menu item.
     * For example, for the newFile menu item, it gets its name which is "New File" and returns "CTRL + N" keystroke.
     * @param menuItem is the menu item of a menu
     * @return the keystroke of the menu item
     */
    public static KeyStroke getShortcut(JMenuItem menuItem) {
        switch (menuItem.getText()) {
            case "New File" -> {
                return KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
            }
            case "New Window" -> {
                return KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK);
            }
            case "Open" -> {
                return KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
            }
            case "Save" -> {
                return KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
            }
            case "Save As" -> {
                return KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK);
            }
            case "Undo" -> {
                return KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK);
            }
            case "Redo" -> {
                return KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK);
            }
            case "Cut" -> {
                return KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
            }
            case "Copy" -> {
                return KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK);
            }
            case "Paste" -> {
                return KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK);
            }
            case "Delete" -> {
                return KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0);
            }
            case "Select All" -> {
                return KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
            }
            default -> {
                return null;
            }
        }
    }

    /**
     * This method is for setting action commands for our menu item.
     * it gets the name of our menu item and sets the item's action command.
     * @param menuItem is the menu item of a menu
     */
    public static void setActionCommand (JMenuItem menuItem) {
        menuItem.setActionCommand(menuItem.getText());
    }

    /**
     * This method is for setting accelerators for our menu item.
     * it gets the keystroke of our menu item based on its name and sets the accelerator.
     * @param menuItem is the menu item of a menu
     */
    public static void setAccelerator(JMenuItem menuItem) {
        menuItem.setAccelerator(Shortcuts.getShortcut(menuItem));
    }
}
