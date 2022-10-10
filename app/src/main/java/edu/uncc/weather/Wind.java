package edu.uncc.weather;

public class Wind {
    double speed;
    double deg;
    double gust;

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                ", gust=" + gust +
                '}';
    }
}
