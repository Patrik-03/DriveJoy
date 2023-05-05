package Editor;

public class Editor
{
	private static final Editor instance = new Editor();
	private Editor()
	{

	}

	public static Editor getInstance()
	{
		return instance;
	}

	public String getID()
	{
		return "1";
	}

	public String getName()
	{
		return "Editor";
	}
}
