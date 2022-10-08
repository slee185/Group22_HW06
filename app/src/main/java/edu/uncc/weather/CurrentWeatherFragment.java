// Homework Assignment 06
// Group22_HW06
// Stephanie Lee Karp
// Ken Stanley

package edu.uncc.weather;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Objects;

import edu.uncc.weather.databinding.FragmentCurrentWeatherBinding;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CurrentWeatherFragment extends Fragment {
    private static final String ARG_PARAM_CITY = "ARG_PARAM_CITY";

    private DataService.City mCity;

    private final OkHttpClient client = new OkHttpClient();
    private Weather weather;

    FragmentCurrentWeatherBinding binding;
    WeatherResponse weatherResponse;

    public CurrentWeatherFragment() {
        // Required empty public constructor
    }

    public CurrentWeatherFragment(iListener listener, Weather weather) {
        this.listener = listener;
        this.weather = weather;
    }

    public static CurrentWeatherFragment newInstance(DataService.City city) {
        CurrentWeatherFragment fragment = new CurrentWeatherFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCurrentWeatherBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Current Weather");

        binding.textViewCityName.setText(mCity.getCity());


        String lat = String.valueOf(mCity.getLat());
        String lon = String.valueOf(mCity.getLat());
        String appid = "b6293da957857aa018c64d4783dad874";

        HttpUrl url = HttpUrl.parse("https://api.openweathermap.org/data/2.5/weather").newBuilder()
                .addQueryParameter("lat", lat)
                .addQueryParameter("lon", lon)
                .addQueryParameter("appid", appid)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                requireActivity().runOnUiThread(() -> Toast.makeText(requireActivity(), "Unable to retrieve current weather from the Internet", Toast.LENGTH_LONG).show());
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (!response.isSuccessful()) {
                    requireActivity().runOnUiThread(() -> Toast.makeText(requireActivity(), "Unable to retrieve current weather from the Internet", Toast.LENGTH_LONG).show());
                    return;
                }

                Gson gson = new Gson();
                weatherResponse = gson.fromJson(Objects.requireNonNull(response.body()).string(), WeatherResponse.class);

                requireActivity().runOnUiThread(() -> {
                    binding.textViewTemp.setText(String.valueOf(weather.temp));
                    binding.textViewTempMax.setText(String.valueOf(weather.temp_max));
                    binding.textViewTempMin.setText(String.valueOf(weather.temp_min));
                    binding.textViewDesc.setText(weather.description);
                    binding.textViewHumidity.setText(String.valueOf(weather.humidity));
                    binding.textViewWindSpeed.setText(String.valueOf(weather.speed));
                    binding.textViewWindDegree.setText(String.valueOf(weather.deg));
                    binding.textViewCloudiness.setText(String.valueOf(weather.all));

                });

            }
        });

        binding.buttonCheckForecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.goToWeatherForecast(mCity);
            }
        });
    }

    iListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (iListener) context;
    }

    interface iListener {
        void goToWeatherForecast(DataService.City city);
    }
}