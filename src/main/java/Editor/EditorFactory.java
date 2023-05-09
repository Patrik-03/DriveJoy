package Editor;

/**
 * EditorFactory is a factory class that creates instances of Editor
 * @see Editor
 */
public class EditorFactory //factory class for Editor
{
	/**
	 * createEditor method creates a new instance of Editor
	 * @return new instance of Editor
	 */
	public Editor createEditor() //create new instance of Editor
	{
		return new Editor(); //return new instance of Editor
	}
}
