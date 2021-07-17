package logic.menuBar;

import logic.myTextArea;
import resources.Fonts;
import util.Shortcuts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the Format menu of the text editor. it handles font wrap, font type, font style, font size, and font color changes.
 * All the actions about changing the looks of the text of our text area is handled in this class.
 */
public class FormatMenu extends JMenu implements ActionListener {
    /**
     * The menu item of Format menu that holds the font as its name suggests
     */
    private JMenuItem arial = new JMenuItem("Arial"),
            bitstreamVeraSans = new JMenuItem("Bitstream Vera Sans"),
            bitstreamVeraSansMono = new JMenuItem("Bitstream Vera Sans Mono"),
            consolas = new JMenuItem("Consolas"),
            dina = new JMenuItem("Dina"),
            lucidaConsole = new JMenuItem("Lucida Console"),
            lucidaSans = new JMenuItem("Lucida Sans"),
            monaco = new JMenuItem("Monaco"),
            timesNewRoman = new JMenuItem("Times New Roman"),
            courierNew = new JMenuItem("Courier New");

    /**
     * The menu item of Font Style menu that holds a font style as its name suggests
     */
    private JMenuItem plain = new JMenuItem("Plain"),
            bold = new JMenuItem("Bold"),
            italic = new JMenuItem("Italic");


    /**
     * The menu item of Format menu that holds certain menu items.
     */
    private JMenu font, fontType, fontStyle;
    private JMenuItem fontColor, fontSize, background;
    private JCheckBoxMenuItem fontWrap;
    myTextArea textArea;
    private static Font textAreaFont;

    /**
     * This constructor initializes the properties of the format menu of our text editor.
     * creation of menu items, setting action listeners and action commands are handled in this constructor.
     * @param textArea is the text area of our text editor
     */
    public FormatMenu(myTextArea textArea) {
        this.textArea = textArea;
        textAreaFont = textArea.getFont();
        this.setText("Format");

        fontWrap = new JCheckBoxMenuItem("Font Wrap");
        fontWrap.setSelected(this.textArea.wrapStatus);
        font = new JMenu("Font");
        fontType = new JMenu("Type");
        fontStyle = new JMenu("Style");
        fontSize = new JMenuItem("Size");
        fontColor = new JMenuItem("Font Color");
        background = new JMenuItem("White Background");

        // *-------Font Action Listeners, Action Commands, Menu Completion-------*
        fontWrap.addActionListener(this);
        fontSize.addActionListener(this);
        fontColor.addActionListener(this);
        background.addActionListener(this);

        Shortcuts.setActionCommand(fontWrap);
        Shortcuts.setActionCommand(fontColor);
        Shortcuts.setActionCommand(fontSize);
        background.setActionCommand("Background");

        font.add(fontType);
        font.add(fontStyle);
        font.add(fontSize);
        // *-------/Font Action Listeners, Action Commands, Menu Completion-------*


        // *-------Font Types Action Listeners-------*
        arial.addActionListener(this);
        bitstreamVeraSans.addActionListener(this);
        bitstreamVeraSansMono.addActionListener(this);
        consolas.addActionListener(this);
        dina.addActionListener(this);
        lucidaConsole.addActionListener(this);
        lucidaSans.addActionListener(this);
        monaco.addActionListener(this);
        timesNewRoman.addActionListener(this);
        courierNew.addActionListener(this);

        plain.addActionListener(this);
        bold.addActionListener(this);
        italic.addActionListener(this);
        // *-------/Font Action Listeners-------*


        // *-------Font Action Commands-------*
        Shortcuts.setActionCommand(arial);
        Shortcuts.setActionCommand(bitstreamVeraSans);
        Shortcuts.setActionCommand(bitstreamVeraSansMono);
        Shortcuts.setActionCommand(consolas);
        Shortcuts.setActionCommand(dina);
        Shortcuts.setActionCommand(lucidaConsole);
        Shortcuts.setActionCommand(lucidaSans);
        Shortcuts.setActionCommand(monaco);
        Shortcuts.setActionCommand(timesNewRoman);
        Shortcuts.setActionCommand(courierNew);

        Shortcuts.setActionCommand(plain);
        Shortcuts.setActionCommand(bold);
        Shortcuts.setActionCommand(italic);
        // *-------/Font Action Commands-------*


        // *-------Font Change in the Menu-------*
        arial.setFont(Fonts.getFontArial());
        bitstreamVeraSans.setFont(Fonts.getFontBitstreamVeraSans());
        bitstreamVeraSansMono.setFont(Fonts.getFontBitstreamVeraSansMono());
        consolas.setFont(Fonts.getFontConsolas());
        dina.setFont(Fonts.getFontDina());
        lucidaConsole.setFont(Fonts.getFontLucidaConsole());
        lucidaSans.setFont(Fonts.getFontLucidaSans());
        monaco.setFont(Fonts.getFontMonaco());
        timesNewRoman.setFont(Fonts.getFontTimesNewRoman());
        courierNew.setFont(Fonts.getFontCourierNew());

        plain.setFont(Fonts.getNewFont("Arial", 0, 14));
        bold.setFont(Fonts.getNewFont("Arial", 1, 14));
        italic.setFont(Fonts.getNewFont("Arial", 2, 14));
        // *-------/Font Change in the Menu-------*


        // *-------Add Fonts to Font Type Menu-------*
        fontType.add(arial);
        fontType.add(bitstreamVeraSans);
        fontType.add(bitstreamVeraSansMono);
        fontType.add(consolas);
        fontType.add(dina);
        fontType.add(lucidaConsole);
        fontType.add(lucidaSans);
        fontType.add(monaco);
        fontType.add(timesNewRoman);
        fontType.add(courierNew);

        fontStyle.add(plain);
        fontStyle.add(bold);
        fontStyle.add(italic);
        // *-------/Add Fonts to Font Type Menu-------*


        // *-------Format Menu Completion-------*
        this.add(fontWrap);
        this.add(font);
        this.add(fontColor);
        this.add(background);
        // *-------/Format Menu Completion-------*
    }

    /**
     * This method handles the font wrap functionality of our text area.
     * It changes the value of font wrap boolean when called.
     */
    private void setFontWrap() {
        this.textArea.wrapStatus = !this.textArea.wrapStatus;
        this.textArea.setLineWrap(textArea.wrapStatus);
        this.textArea.setWrapStyleWord(textArea.wrapStatus);
    }

    /**
     * This method is for changing the size of the font.
     * It opens an input dialog and only accepts numbers as an input.
     */
    private void setFontSize() {
        String size;
        do {
            size = JOptionPane.showInputDialog(null, "Insert Size:",
                    "Size", JOptionPane.PLAIN_MESSAGE);
        } while (size.matches(".*[\\D].*"));
        this.textArea.setFont(Fonts.getNewFont(this.textArea.getFont().getFontName()
                , this.textArea.getFont().getStyle(), Integer.parseInt(size)));
    }

    /**
     * This method is for changing the color of the text of our text area.
     * It opens a color chooser that the user can choose the color from it.
     */
    private void setFontColor() {
        this.textArea.setForeground(JColorChooser.showDialog(null, "Color Table", Color.GREEN));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Font Wrap" -> setFontWrap();
            case "Size" -> setFontSize();
            case "Font Color" -> setFontColor();
            case "Background" -> {
                if (this.textArea.getBackground() != Color.WHITE) {
                    this.background.setText("Black Background");
                    this.textArea.setBackground(Color.WHITE);
                    this.textArea.setCaretColor(Color.BLACK);
                } else {
                    this.background.setText("White Background");
                    this.textArea.setBackground(Color.BLACK);
                    this.textArea.setCaretColor(Color.WHITE);
                }
            }
            case "Plain" -> this.textArea.setFont(Fonts.getNewFont(textAreaFont.getFontName(), 0, textAreaFont.getSize()));
            case "Bold" -> this.textArea.setFont(Fonts.getNewFont(textAreaFont.getFontName(), 1, textAreaFont.getSize()));
            case "Italic" -> this.textArea.setFont(Fonts.getNewFont(textAreaFont.getFontName(), 2, textAreaFont.getSize()));
            case "Arial", "Bitstream Vera Sans", "Bitstream Vera Sans Mono", "Consolas", "Dina", "Lucida Console", "Lucida Sans",
                    "Monaco", "Times New Roman", "Courier New" -> {
                this.textArea.setFont(Fonts.getNewFont(command, textAreaFont.getStyle(), textAreaFont.getSize()));
                textAreaFont = this.textArea.getFont();
            }
        }
    }
}
