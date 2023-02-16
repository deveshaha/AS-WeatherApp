package com.dam.theweatherapp.api;

import com.dam.theweatherapp.data.WeatherRes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiRestService {
    //get the weather from the api but we need to add the parameters of longitude and latitude

    public static final String BASE_URL = "https://api.darksky.net/forecast/"; //we need to add the api key

    @GET("weather")
    Call<WeatherRes> getWeather(@Path("latitude") double latitude, @Path("longitude") double longitude, @Path("API_KEY") String API_KEY);
}
