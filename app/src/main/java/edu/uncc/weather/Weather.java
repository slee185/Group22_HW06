// Homework Assignment 06
// Group22_HW06
// Stephanie Lee Karp
// Ken Stanley
package edu.uncc.weather;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("Temp")
    Boolean temp;
    @SerializedName("Temp_Min")
    Boolean temp_min;
    @SerializedName("Temp_Max")
    Boolean temp_max;
    @SerializedName("Description")
    String description;
    @SerializedName("Humidity")
    Integer humidity;
    @SerializedName("Speed")
    Boolean speed;
    @SerializedName("Deg")
    Boolean deg;
    @SerializedName("Cloudiness")
    Integer all;

    @NonNull
    @Override
    public String toString() {
        return "Weather{" +
                "Temp=" + temp +
                ", maxTemp='" + temp_min + '\'' +
                ", minTemp='" + temp_max + '\'' +
                ", description='" + description + '\'' +
                ", humidity='" + humidity + '\'' +
                ", windSpeed='" + speed + '\'' +
                ", windDegree='" + deg + '\'' +
                ", cloudiness='" + all + '\'' +
                '}';
    }
}
