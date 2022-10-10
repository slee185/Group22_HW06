package edu.uncc.weather;

public class City extends Sys {
    int id;
    String name;
    Coord coord;
    int population;
    long timezone;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coord=" + coord +
                ", population=" + population +
                ", timezone=" + timezone +
                ", country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }
}
