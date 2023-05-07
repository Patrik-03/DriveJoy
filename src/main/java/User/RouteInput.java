package User;

/**
 * This class is used to get the location of the route from the user
 */
public class RouteInput // This class is used to get the location of the route from the user
{
    /**
     * This is the location of the route
     */
    private String location;

    /**
     * Constructor
     * @param location This is the location of the route
     */
    public RouteInput(String location) // Constructor
    {
        this.location = location;
    }
    /**
     * Getter
     * @return location
     */
    public String getLocation() // Getter
    {
        return location;
    }

}
