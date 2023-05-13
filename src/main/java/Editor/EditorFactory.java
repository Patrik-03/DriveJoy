package Editor;

/**
 * This class is used to create an editor.
 * It has a method to create an editor.
 */
public class EditorFactory
{
    /**
     * This is the constructor of the class.
     */
    public EditorFactory() //constructor
    {
    }
    /**
     * This method is used to create an editor.
     * @return the editor.
     */
    public Editor createEditor() {
        return new Editor();
    }
}
