package Icons;

public class GoIcons implements GO
{
	private String[] icons = new String[4];

	public GoIcons()
	{

	}
	public void checkType(String type)
	{
		if(type.equals("Car"))
		{
			setLambo();
			setCabrio();
		}
		else if(type.equals("Motorbike"))
		{
			setScooter();
			setMotorbike();
		}
	}

	private void setMotorbike()
	{
		icons[0] = "src/main/resources/Icons/motorbike.png";
	}

	private void setScooter()
	{
		icons[1] = "src/main/resources/Icons/scooter.png";
	}

	private void setCabrio()
	{
		icons[2] = "src/main/resources/Icons/cabrio.png";
	}

	private void setLambo()
	{
		icons[3] = "src/main/resources/Icons/lambo.png";
	}

	public String[] getIcons()
	{
		return icons;
	}
	public void setIcons(String[] icons)
	{
		this.icons = icons;
	}
}
