// Homework Assignment 06
// Group22_HW06
// Stephanie Lee Karp
// Ken Stanley
package edu.uncc.weather;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Weather {
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
