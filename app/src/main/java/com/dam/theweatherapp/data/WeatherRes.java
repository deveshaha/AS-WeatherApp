package com.dam.theweatherapp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherRes {

    @SerializedName("latitude")
    @Expose
    public Double latitude;
    @SerializedName("longitude")
    @Expose
    public Double longitude;
    @SerializedName("timezone")
    @Expose
    public String timezone;
    @SerializedName("currently")
    @Expose
    public Currently currently;
    @SerializedName("offset")
    @Expose
    public Integer offset;

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public Currently getCurrently() {
        return currently;
    }

    public Integer getOffset() {
        return offset;
    }
}
