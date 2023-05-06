package Editor;
import Exception.WrongIdException;
import GUI.Alert;
import GUI.AlertBox;

import java.util.Objects;

public class EditorRoles extends EditorInput
{
    private String ID;
    private String name;
    Editor editor;

    public EditorRoles(String id)
    {
        super(id);
        this.ID = id;
        this.editor = Editor.getInstance();
    }
    public void checkID() throws WrongIdException
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getID()
    {
        return ID;
    }
}
