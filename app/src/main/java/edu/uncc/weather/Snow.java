package edu.uncc.weather;

import com.google.gson.annotations.SerializedName;

public class Snow {
    @SerializedName("1h")
    double oneHour;
    @SerializedName("3h")
    double threeHour;

    @Override
    public String toString() {
        return "Snow{" +
                "oneHour=" + oneHour +
                ", threeHour=" + threeHour +
                '}';
    }
}
