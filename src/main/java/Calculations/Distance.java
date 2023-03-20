package Calculations;

import java.util.Objects;

public class Distance
{
    public  int getDistance(String location1, String location2)
    {
        int distance = 0;
        if(Objects.equals(location1, "Piešťany") && Objects.equals(location2, "Topolčany") || Objects.equals(location1, "Topolčany") && Objects.equals(location2, "Piešťany"))
        {
            distance = 33;
        }
        if(Objects.equals(location1, "Pezinok") && Objects.equals(location2, "Malacky") || Objects.equals(location1, "Malacky") && Objects.equals(location2, "Pezinok"))
        {
            distance = 32;
        }
        if(Objects.equals(location1, "Štrba") && Objects.equals(location2, "Štrbske Pleso") || Objects.equals(location1, "Štrbske Pleso") && Objects.equals(location2, "Štrba"))
        {
            distance = 13;
        }
        if (Objects.equals(location1, "Prato allo Stelvio") && Objects.equals(location2, "Passo dello Stelvio") || Objects.equals(location1, "Passo dello Stelvio") && Objects.equals(location2, "Prato allo Stelvio"))
        {
            distance = 24;
        }
        if(Objects.equals(location1, "Omiš") && Objects.equals(location2, "Seoca") || Objects.equals(location1, "Seoca") && Objects.equals(location2, "Omiš"))
        {
            distance = 18;
        }
        return distance;
    }

}
