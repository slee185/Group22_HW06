// Homework Assignment 06
// Group22_HW06
// Stephanie Lee Karp
// Ken Stanley

package edu.uncc.weather;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class WeatherResponse {
    Coord coord;
    ArrayList<Weather> weather;
    Main main;
    int visibility;
    Wind wind;
    Rain rain;
    Clouds clouds;
    int dt;
    Sys sys;
    int timezone;
    int id;
    String name;

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "coord=" + coord +
                ", weather=" + weather +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", rain=" + rain +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", timezone=" + timezone +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
