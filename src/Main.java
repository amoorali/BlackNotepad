import logic.TextEditor;

/**
 * This app is a simple text editor that can do basic text editing actions, save and open .txt files.
 * It has black background and green text as its default colors, and can support UTF-8 encoding.
 * @author AmirAli Fallahi
 */
public class Main {
    public static void main(String[] args) {
        new TextEditor(500, 300);
    }
}
