// Homework Assignment 06
// Group22_HW06
// Stephanie Lee Karp
// Ken Stanley

package edu.uncc.weather;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import edu.uncc.weather.databinding.FragmentWeatherForecastBinding;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherForecastFragment extends Fragment {
    private static final String ARG_PARAM_CITY = "ARG_PARAM_CITY";

    private DataService.City mCity;

    private final OkHttpClient client = new OkHttpClient();

    FragmentWeatherForecastBinding binding;
    ForecastResponse forecastResponse;

    public WeatherForecastFragment() {
        // Required empty public constructor
    }

    public static WeatherForecastFragment newInstance(DataService.City city) {
        WeatherForecastFragment fragment = new WeatherForecastFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_CITY, city);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCity = (DataService.City) getArguments().getSerializable(ARG_PARAM_CITY);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWeatherForecastBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requireActivity().setTitle("Weather Forecast");

        binding.textViewCityName.setText(getString(R.string.city_country, mCity.getCity(), mCity.getCountry()));

        String lat = String.valueOf(mCity.getLat());
        String lon = String.valueOf(mCity.getLat());
        String appid = "b6293da957857aa018c64d4783dad874";

        HttpUrl url = Objects.requireNonNull(HttpUrl.parse("https://api.openweathermap.org/data/2.5/forecast")).newBuilder()
                .addQueryParameter("lat", lat)
                .addQueryParameter("lon", lon)
                .addQueryParameter("units", "imperial")
                .addQueryParameter("appid", appid)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                requireActivity().runOnUiThread(() -> Toast.makeText(requireActivity(), "Unable to retrieve weather forecast from the Internet", Toast.LENGTH_LONG).show());
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (!response.isSuccessful()) {
                    requireActivity().runOnUiThread(() -> Toast.makeText(requireActivity(), "Unable to retrieve weather forecast from the Internet", Toast.LENGTH_LONG).show());
                    return;
                }

                Gson gson = new Gson();
                forecastResponse = gson.fromJson(Objects.requireNonNull(response.body()).string(), ForecastResponse.class);

                requireActivity().runOnUiThread(() -> {
                    binding.listView.setAdapter(new ForecastAdapter(
                            requireActivity(),
                            R.layout.forecast_row_item,
                            forecastResponse.list,
                            forecastResponse.city
                    ));
                });
            }
        });
    }

    public class ForecastAdapter extends ArrayAdapter<edu.uncc.weather.List> {
        City city;

        public ForecastAdapter(@NonNull Context context, int resource, @NonNull List<edu.uncc.weather.List> objects, City city) {
            super(context, resource, objects);
            this.city = city;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.forecast_row_item, parent, false);
            }

            edu.uncc.weather.List list = getItem(position);
            Weather weather = list.weather.get(0);

            ((TextView)convertView.findViewById(R.id.textViewDateTime)).setText(list.dt_txt);
            ((TextView)convertView.findViewById(R.id.textViewTemp)).setText(getString(R.string.temp_fahrenheit, list.main.temp));
            ((TextView)convertView.findViewById(R.id.textViewTempMax)).setText(getString(R.string.temp_max, list.main.temp_max));
            ((TextView)convertView.findViewById(R.id.textViewTempMin)).setText(getString(R.string.temp_min, list.main.temp_min));
            ((TextView)convertView.findViewById(R.id.textViewHumidity)).setText(getString(R.string.humidity_percent, list.main.humidity));
            ((TextView)convertView.findViewById(R.id.textViewDesc)).setText(weather.description);

            // Get the image icon for the current weather
            String url = "https://openweathermap.org/img/wn/" + weather.icon + "@2x.png";
            Picasso.get().load(url).into((ImageView) convertView.findViewById(R.id.imageViewWeatherIcon2));

            return convertView;
        }
    }
}