// Homework Assignment 06
// Group22_HW06
// Stephanie Lee Karp
// Ken Stanley

package edu.uncc.weather;

import java.util.ArrayList;

public class ForecastResponse {
    int dt;
    Main main;
    ArrayList<Weather> weather;
    Clouds clouds;
    Wind wind;
    int visibility;
    Boolean pop;
    Rain rain;
    Sys sys;
    Forecast forecast;

    @Override
    public String toString() {
        return "WeatherResponse{" +
                ", dt=" + dt +
                ", main=" + main +
                ", weather=" + weather +
                ", clouds=" + clouds +
                ", wind=" + wind +
                ", visibility=" + visibility +
                ", pop=" + pop +
                ", rain=" + rain +
                ", sys=" + sys +
                ", forecast=" + forecast + '\'' +
                '}';
    }
}
