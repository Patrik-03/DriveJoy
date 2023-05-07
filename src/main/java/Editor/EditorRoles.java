package Editor;
import Exception.WrongIdException;
import GUI.Alert;
import GUI.AlertBox;

import java.util.Objects;

/**
 * This class is used to check the ID of the editor.
 * It extends EditorInput class.
 * It has a method to check the ID of the editor.
 * It has a getter for the name of the editor.
 * It has a setter for the name of the editor.
 * It has a getter for the ID of the editor.
 * @see EditorInput
 */
public class EditorRoles extends EditorInput //class to check ID
{
    /**
     * This is the name of the editor.
     */
    private String ID; //ID of the editor
    /**
     * This is the name of the editor.
     */
    private String name; //name of the editor
    /**
     * This is the instance of the editor.
     */
    Editor editor; //instance of the editor

    /**
     * This is the constructor of the class.
     * @param id is the ID of the editor.
     */
    public EditorRoles(String id) //constructor
    {
        super(id);
        this.ID = id;
        this.editor = Editor.getInstance();
    }
    /**
     * This method is used to check the ID of the editor.
     * @throws WrongIdException if the ID is wrong.
     */
    public void checkID() throws WrongIdException //method to check ID
    {
        if(Objects.equals(super.getID(), editor.getID()))
        {
            this.name = editor.getName();
        }
        else
        {
            Alert alert = new AlertBox();
            alert.alert();
            throw new WrongIdException("Wrong ID");
        }
    }
    /**
     * This method is used to get the name of the editor.
     * @return the name of the editor.
     */
    public String getName() //getter
    {
        return name;
    }
    /**
     * This method is used to set the name of the editor.
     * @param name is the name of the editor.
     */
    public void setName(String name) //setter
    {
        this.name = name;
    }
    /**
     * This method is used to get the ID of the editor.
     * @return the ID of the editor.
     */
    @Override
    public String getID() //getter for ID from EditorInput
    {
        return ID;
    }
}
