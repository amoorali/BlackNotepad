package resources;

import javax.swing.*;

/**
 * This class holds the icons for our text editor
 */
public class ImageCreator {
    private static ImageCreator instance = new ImageCreator();

    /**
     * This class is a single-tone class, so we make an instance of this class inorder to access it's methods through it.
     * @return the instance of ImageCreator class.
     */
    public static ImageCreator getInstance() {
        return instance;
    }

    /**
     * This is the address of our icons.
     */
    private final ImageIcon
            appIcon = new ImageIcon(new ImageIcon("src\\resources\\images\\BlackNotepad.png").getImage().getScaledInstance(20,20,java.awt.Image.SCALE_SMOOTH)),
            saveIcon = new ImageIcon(new ImageIcon("src\\resources\\images\\SaveImage.png").getImage().getScaledInstance(20,20,java.awt.Image.SCALE_SMOOTH)),
            openIcon = new ImageIcon(new ImageIcon("src\\resources\\images\\OpenImage.png").getImage().getScaledInstance(20,20,java.awt.Image.SCALE_SMOOTH)),
            newFileIcon = new ImageIcon(new ImageIcon("src\\resources\\images\\NewFileImage.png").getImage().getScaledInstance(20,20,java.awt.Image.SCALE_SMOOTH)),
            newWindowIcon = new ImageIcon(new ImageIcon("src\\resources\\images\\NewWindowImage.jpg").getImage().getScaledInstance(20,20,java.awt.Image.SCALE_SMOOTH));

    public ImageIcon getAppIcon() {
        return appIcon;
    }

    public ImageIcon getSaveIcon() {
        return saveIcon;
    }

    public ImageIcon getOpenIcon() {
        return openIcon;
    }

    public ImageIcon getNewFileIcon() {
        return newFileIcon;
    }

    public ImageIcon getNewWindowIcon() {
        return newWindowIcon;
    }
}
