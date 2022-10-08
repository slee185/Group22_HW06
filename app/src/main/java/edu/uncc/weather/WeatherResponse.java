// Homework Assignment 06
// Group22_HW06
// Stephanie Lee Karp
// Ken Stanley

package edu.uncc.weather;

import androidx.annotation.NonNull;

public class WeatherResponse {
    String status;
    Weather weather;

    @NonNull
    @Override
    public String toString() {
        return "WeatherResponse{" +
                "status='" + status + '\'' +
                ", weather=" + weather +
                '}';
    }
}
