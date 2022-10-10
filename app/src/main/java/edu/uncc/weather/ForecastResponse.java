// Homework Assignment 06
// Group22_HW06
// Stephanie Lee Karp
// Ken Stanley

package edu.uncc.weather;

import java.util.ArrayList;

public class ForecastResponse {
    int cnt;
    ArrayList<List> list;
    City city;

    @Override
    public String toString() {
        return "ForecastResponse{" +
                "cnt=" + cnt +
                ", list=" + list +
                ", city=" + city +
                '}';
    }
}
