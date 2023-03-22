package Calculations;

public class DisplayOptions
{
    public String displayOptions(String locate)
    {
        String location = null;
        Distance distance = new Distance();
        if (locate.equals("Piešťany"))
        {
            location = String.valueOf(distance.getDistance("Piešťany", "Topolčany"));
        }
        if (locate.equals("Topolčany"))
        {
            location = String.valueOf(distance.getDistance("Piešťany", "Topolčany"));
        }
        if (locate.equals("Pezinok"))
        {
            location = String.valueOf(distance.getDistance("Pezinok", "Malacky"));
        }
        if (locate.equals("Malacky"))
        {
            location = String.valueOf(distance.getDistance("Pezinok", "Malacky"));
        }
        if (locate.equals("Štrba"))
        {
            location = String.valueOf(distance.getDistance("Štrba", "Štrbske Pleso"));
        }
        if (locate.equals("Štrbske Pleso"))
        {
            location = String.valueOf(distance.getDistance("Štrba", "Štrbske Pleso"));
        }
        if (locate.equals("Prato allo Stelvio"))
        {
            location = String.valueOf(distance.getDistance("Prato allo Stelvio", "Passo dello Stelvio"));
        }
        if (locate.equals("Passo dello Stelvio"))
        {
            location = String.valueOf(distance.getDistance("Prato allo Stelvio", "Passo dello Stelvio"));
        }
        if (locate.equals("Omiš"))
        {
            location = String.valueOf(distance.getDistance("Omiš", "Seoca"));
        }
        if (locate.equals("Seoca"))
        {
            location = String.valueOf(distance.getDistance("Omiš", "Seoca"));
        }
        return location;
    }
}
