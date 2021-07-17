package logic;

import javax.swing.*;
import java.awt.*;

/**
 * This class is the JTextArea in our editor
 * @author AmirAli Fallahi
 */

public class myTextArea extends JTextArea {
    JScrollPane scrollPane;
    public boolean wrapStatus = false;
    public boolean saveStatus = true;
    int x, y;

    /**
     * This constructor is for initializing our TextArea's properties
     */
    public myTextArea() {
        this.setFont(new Font("Consolas", Font.PLAIN, 50).decode("Cp1256"));
        this.setLineWrap(wrapStatus);
        this.setWrapStyleWord(wrapStatus);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.GREEN);
        this.setCaretColor(Color.WHITE);

        scrollPane = new JScrollPane(this);
        scrollPane.setPreferredSize(new Dimension(1000,700));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
    }

    /**
     * This method is for adjusting the position of our frame on the x-axis for opening new window
     * @param x is the position of our frame on the x-axis
     */
    public void setXPosition(int x) {
        this.x = x;
    }

    /**
     * This method is for adjusting the position of our frame on the y-axis for opening new window
     * @param y is the position of our frame on the y-axis
     */
    public void setYPosition(int y) {
        this.y = y;
    }

    /**
     * This method is for getting the position of our frame on the x-axis
     * @return is the position of our frame on the x-axis
     */
    public int getXPosition() {
        return this.x;
    }

    /**
     * This method is for getting the position of our frame on the y-axis
     * @return is the position of our frame on the y-axis
     */
    public int getYPosition() {
        return this.y;
    }
}
