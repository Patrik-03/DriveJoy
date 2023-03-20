package Editor;
public class EditorRoles
{
    public static String checkID(String id)
    {
        String[] editors = {"Admin", "Editor"};
        String[] ID = {"1", "2"};
        for (int i = 0; i < ID.length; i++)
        {
            if (ID[i].equals(id)) {
                return editors[i];
            }
        }
        return null;
    }
}
