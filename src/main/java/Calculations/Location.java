package Calculations;

import java.util.Objects;

public class Location
{
    public String loc(String position)
    {
        String location = null;

        if(Objects.equals(position, "Piešťany"))
        {
            location = "Piešťany";
        }
        if (Objects.equals(position, "Topolčany"))
        {
            location = "Topolčany";
        }
        if (Objects.equals(position, "Pezinok"))
        {
            location = "Pezinok";
        }
        if (Objects.equals(position, "Malacky"))
        {
            location = "Malacky";
        }
        if (Objects.equals(position, "Štrba"))
        {
            location = "Štrba";
        }
        if (Objects.equals(position, "Štrbske Pleso"))
        {
            location = "Štrbske Pleso";
        }
        if (Objects.equals(position, "Prato allo Stelvio"))
        {
            location = "Prato allo Stelvio";
        }
        if (Objects.equals(position, "Passo dello Stelvio"))
        {
            location = "Passo dello Stelvio";
        }
        if (Objects.equals(position, "Omiš"))
        {
            location = "Omiš";
        }
        if (Objects.equals(position, "Seoca"))
        {
            location = "Seoca";
        }
        return location;
    }
}
