package Editor;
import Exception.WrongIdException;
import java.util.Objects;

public class EditorRoles extends EditorInput
{
    String ID;
    public String name;
    Editor editor;
    public EditorRoles(String id)
    {
        super(id);
        this.ID = id;
        this.editor = new Editor();
    }
    public void checkID() throws WrongIdException
    {
        if(Objects.equals(super.getID(), editor.getID()))
        {
            this.name = editor.getName();
        }
        else
        {
            throw new WrongIdException("Wrong ID");
        }
    }
}
