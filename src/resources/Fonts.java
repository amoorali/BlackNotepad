package resources;

import logic.myTextArea;

import java.awt.*;

/**
 * This class holds some types of fonts
 */
public class Fonts extends myTextArea {

    /**
     * This is for manipulating fonts
     * @param name is the name of the font
     * @param style is the style of the font. 0 for PLAIN, 1 for BOLD, 2 for ITALIC
     * @param size is the size of the font
     * @return new font based on the parameters
     */
    public static Font getNewFont(String name, int style, int size) {
        return new Font(name, style, size);
    }

    /**
     * This method is for Arial font type
     * @return Arial font type with plain style and 14 for it's size
     */
    public static Font getFontArial () {
        return new Font("Arial", Font.PLAIN, 14);
    }

    /**
     * This method is for Bitstream Vera Sans font type
     * @return Bitstream Vera Sans font type with plain style and 14 for it's size
     */
    public static Font getFontBitstreamVeraSans () {
        return new Font("Bitstream Vera Sans", Font.PLAIN, 14);
    }

    /**
     * This method is for Bitstream Vera Sans Mono font type
     * @return Bitstream Vera Sans Mono font type with plain style and 14 for it's size
     */
    public static Font getFontBitstreamVeraSansMono () {
        return new Font("Bitstream Vera Sans Mono", Font.PLAIN, 14);
    }

    /**
     * This method is for Consolas font type
     * @return Consolas font type with plain style and 14 for it's size
     */
    public static Font getFontConsolas () {
        return new Font("Consolas", Font.PLAIN, 14);
    }

    /**
     * This method is for Dina font type
     * @return Dina font type with plain style and 14 for it's size
     */
    public static Font getFontDina () {
        return new Font("Dina", Font.PLAIN, 14);
    }

    /**
     * This method is for Lucida Console font type
     * @return Lucida Console font type with plain style and 14 for it's size
     */
    public static Font getFontLucidaConsole () {
        return new Font("Lucida Console", Font.PLAIN, 14);
    }

    /**
     * This method is for Lucida Sans font type
     * @return Lucida Sans font type with plain style and 14 for it's size
     */
    public static Font getFontLucidaSans () {
        return new Font("Lucida Sans", Font.PLAIN, 14);
    }

    /**
     * This method is for Monaco font type
     * @return Monaco font type with plain style and 14 for it's size
     */
    public static Font getFontMonaco () {
        return new Font("Monaco", Font.PLAIN, 14);
    }

    /**
     * This method is for Times New Roman font type
     * @return Times New Roman font type with plain style and 14 for it's size
     */
    public static Font getFontTimesNewRoman () {
        return new Font("Times New Roman", Font.PLAIN, 14);
    }

    /**
     * This method is for Courier New font type
     * @return Courier New font type with plain style and 14 for it's size
     */
    public static Font getFontCourierNew () {
        return new Font("Courier New", Font.PLAIN, 14);
    }
}
