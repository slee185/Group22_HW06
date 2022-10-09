package edu.uncc.weather;

import com.google.gson.annotations.SerializedName;

public class Rain {
    @SerializedName("1h")
    double oneHour;
    @SerializedName("3h")
    double threeHour;

    @Override
    public String toString() {
        return "Rain{" +
                "oneHour=" + oneHour +
                ", threeHour=" + threeHour +
                '}';
    }
}
