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
    @SerializedName("MaxTemp")
    Boolean maxTemp;
    @SerializedName("MinTemp")
    Boolean minTemp;
    @SerializedName("Description")
    String description;
    @SerializedName("Humidity")
    Integer humidity;
    @SerializedName("WindSpeed")
    Boolean windSpeed;
    @SerializedName("WindDegree")
    Boolean windDegree;
    @SerializedName("Cloudiness")
    Integer cloudiness;

    @NonNull
    @Override
    public String toString() {
        return "Weather{" +
                "Temp=" + temp +
                ", maxTemp='" + maxTemp + '\'' +
                ", minTemp='" + minTemp + '\'' +
                ", description='" + description + '\'' +
                ", humidity='" + humidity + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", windDegree='" + windDegree + '\'' +
                ", cloudiness='" + cloudiness + '\'' +
                '}';
    }
}
