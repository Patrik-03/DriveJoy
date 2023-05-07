package Editor;

/**
 * EditorInput class for editor
 * @see Editor
 */
public class EditorInput //input class for editor
{
    /**
     * id of editor
     */
    private String ID; //id of editor
    /**
     * Constructor for EditorInput
     * @param id id of editor
     */
    public EditorInput(String id) //constructor
    {
        this.ID = id;
    }
    /**
     * Getter for id
     * @return id of editor
     */
    public String getID() //getter for id
    {
        return this.ID;
    }
}
