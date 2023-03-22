package Calculations;

import java.util.Objects;

public class Location
{
    public String getLocationName(String position)
    {
        String location = null;

        if(Objects.equals(position, "Piešťany"))
        {
            location = "Piešťany -> Topolčany";
        }
        if (Objects.equals(position, "Topolčany"))
        {
            location = "Topolčany -> Piešťany";
        }
        if (Objects.equals(position, "Pezinok"))
        {
            location = "Pezinok -> Malacky";
        }
        if (Objects.equals(position, "Malacky"))
        {
            location = "Malacky -> Pezinok";
        }
        if (Objects.equals(position, "Štrba"))
        {
            location = "Štrba -> Štrbske Pleso";
        }
        if (Objects.equals(position, "Štrbske Pleso"))
        {
            location = "Štrbske Pleso -> Štrba";
        }
        if (Objects.equals(position, "Prato allo Stelvio"))
        {
            location = "Prato allo Stelvio -> Passo dello Stelvio";
        }
        if (Objects.equals(position, "Passo dello Stelvio"))
        {
            location = "Passo dello Stelvio -> Prato allo Stelvio";
        }
        if (Objects.equals(position, "Omiš"))
        {
            location = "Omiš -> Seoca";
        }
        if (Objects.equals(position, "Seoca"))
        {
            location = "Seoca -> Omiš";
        }
        return location;
    }
}
