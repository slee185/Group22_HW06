// Homework Assignment 06
// Group22_HW06
// Stephanie Lee Karp
// Ken Stanley
package edu.uncc.weather;

public class Forecast {
    int id;
    String main;
    String description;
    String icon;

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
