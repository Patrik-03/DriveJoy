package Editor;

/**
 * Editor class is a singleton class that is used to get the id and name of the editor
 * @see Editor
 */
public class Editor //editor class is a singleton
{
	/**
	 * instance of editor
	 */
	private static final Editor instance = new Editor(); //create an instance of editor
	/**
	 * private constructor
	 */
	private Editor() //private constructor
	{

	}

	/**
	 * getInstance method returns the instance of editor
	 * @return instance of editor
	 */
	public static Editor getInstance() //get instance of editor
	{
		return instance; //return instance
	}
	/**
	 * getID method returns the id of editor
	 * @return id of editor
	 */
	public String getID() //get id of editor
	{
		return "1";
	}
	/**
	 * getName method returns the name of editor
	 * @return name of editor
	 */
	public String getName() //get name of editor
	{
		return "Editor";
	}
}
