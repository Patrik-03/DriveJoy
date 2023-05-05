package Icons;

public class GoIcons implements GO
{
	private String lambo;
	private String cabrio;
	private String scooter;
	private String motorbike;
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
	public String getLambo()
	{
		return lambo;
	}
	public void setLambo()
	{
		this.lambo = "lambo.png";
	}
	public String getCabrio()
	{
		return cabrio;
	}
	public void setCabrio()
	{
		this.cabrio = "cabrio.png";
	}
	public String getScooter()
	{
		return scooter;
	}
	public void setScooter()
	{
		this.scooter = "scooter.png";
	}
	public String getMotorbike()
	{
		return motorbike;
	}
	public void setMotorbike()
	{
		this.motorbike = "motorbike.png";
	}
	public String random(String type)
	{
		if(type.equals("Car"))
		{
			int random = (int) (Math.random() * 2);
			if(random == 0)
			{
				return getLambo();
			}
			else
			{
				return getCabrio();
			}
		}
		else if(type.equals("Motorbike"))
		{
			int random = (int) (Math.random() * 2);
			if(random == 0)
			{
				return getScooter();
			}
			else
			{
				return getMotorbike();
			}
		}
		else
		{
			return null;
		}
	}
}
