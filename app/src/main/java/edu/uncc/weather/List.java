package edu.uncc.weather;

public class List extends WeatherResponse {
    double pop;
    String dt_txt;

    @Override
    public String toString() {
        return "List{" +
                "pop=" + pop +
                ", dt_txt='" + dt_txt + '\'' +
                ", coord=" + coord +
                ", weather=" + weather +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", rain=" + rain +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", timezone=" + timezone +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
