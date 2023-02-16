package com.dam.theweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dam.theweatherapp.api.ApiRestService;
import com.dam.theweatherapp.api.RetrofitClient;
import com.dam.theweatherapp.data.Currently;
import com.dam.theweatherapp.data.WeatherRes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WeatherActivity extends AppCompatActivity {

    TextView tvRegion, tvHour, tvTemp, tvHumidityValue, tvRainValue;
    ImageView ivWeather;
    ProgressBar pb;

    private static final String API_KEY = "11ce4328111023379e0fdc9d28c24a02";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        tvRegion = findViewById(R.id.tvRegion);
        tvHour = findViewById(R.id.tvHour);
        tvTemp = findViewById(R.id.tvTemp);
        tvHumidityValue = findViewById(R.id.tvHumidityValue);
        tvRainValue = findViewById(R.id.tvRainValue);
        ivWeather = findViewById(R.id.ivWeather);
        //pb = findViewById(R.id.progressBar);
        pb.setVisibility(View.GONE);

        getWeatherData();
    }

    private void getWeatherData(){
        //Double lat = getIntent().getDoubleExtra("lat", 0);
        //Double lon = getIntent().getDoubleExtra("lon", 0);

        Double lat = 40.5;
        Double lon  = -3.7;
        Retrofit r = RetrofitClient.getClient(ApiRestService.BASE_URL);
        ApiRestService ars = r.create(ApiRestService.class);
        Call<WeatherRes> call = ars.getWeather(lat, lon, API_KEY);

        pb.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<WeatherRes>() {
            @Override
            public void onResponse(Call<WeatherRes> call, Response<WeatherRes> response) {
                if(response.isSuccessful()){
                    WeatherRes weatherRes = response.body();
                    Currently currently = weatherRes.getCurrently();
                    tvRegion.setText(weatherRes.getTimezone());
                    tvHour.setText(currently.getTime());
                    tvTemp.setText(currently.getTemperature().toString());
                    tvHumidityValue.setText(currently.getHumidity().toString());
                    tvRainValue.setText(currently.getPrecipProbability().toString());
                    //check the summary and set the image
                    String summary = currently.getSummary();
                    switch (summary) {
                        case "Clear":
                            ivWeather.setImageResource(R.drawable.clear_day);
                            break;
                        case "Partly Cloudy":
                            ivWeather.setImageResource(R.drawable.partly_cloudy);
                            break;
                        case "Cloudy":
                            ivWeather.setImageResource(R.drawable.cloudy);
                            break;
                        case "Rain":
                            ivWeather.setImageResource(R.drawable.rain);
                            break;
                        case "Snow":
                            ivWeather.setImageResource(R.drawable.snow);
                            break;
                        case "Sleet":
                            ivWeather.setImageResource(R.drawable.sleet);
                            break;
                        case "Wind":
                            ivWeather.setImageResource(R.drawable.wind);
                            break;
                        case "Fog":
                            ivWeather.setImageResource(R.drawable.fog);
                            break;
                        case "Clear Night":
                            ivWeather.setImageResource(R.drawable.clear_night);
                            break;
                        case "Cloudy Night":
                            ivWeather.setImageResource(R.drawable.cloudy_night);
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherRes> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });

    }

}