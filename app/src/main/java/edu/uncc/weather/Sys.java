package edu.uncc.weather;

public class Sys {
    String country;
    int sunrise;
    int sunset;

    @Override
    public String toString() {
        return "Sys{" +
                "country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }
}
