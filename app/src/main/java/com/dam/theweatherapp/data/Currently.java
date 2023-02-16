package com.dam.theweatherapp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currently {

    @SerializedName("time")
    @Expose
    public Integer time;
    @SerializedName("summary")
    @Expose
    public String summary;
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("precipIntensity")
    @Expose
    public Integer precipIntensity;
    @SerializedName("precipProbability")
    @Expose
    public Integer precipProbability;
    @SerializedName("temperature")
    @Expose
    public Double temperature;
    @SerializedName("apparentTemperature")
    @Expose
    public Double apparentTemperature;
    @SerializedName("dewPoint")
    @Expose
    public Double dewPoint;
    @SerializedName("humidity")
    @Expose
    public Double humidity;
    @SerializedName("pressure")
    @Expose
    public Double pressure;
    @SerializedName("windSpeed")
    @Expose
    public Double windSpeed;
    @SerializedName("windGust")
    @Expose
    public Double windGust;
    @SerializedName("windBearing")
    @Expose
    public Integer windBearing;
    @SerializedName("cloudCover")
    @Expose
    public Double cloudCover;
    @SerializedName("uvIndex")
    @Expose
    public Integer uvIndex;
    @SerializedName("visibility")
    @Expose
    public Integer visibility;
    @SerializedName("ozone")
    @Expose
    public Double ozone;

    public Integer getTime() {
        return time;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public Integer getPrecipIntensity() {
        return precipIntensity;
    }

    public Integer getPrecipProbability() {
        return precipProbability;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getApparentTemperature() {
        return apparentTemperature;
    }

    public Double getDewPoint() {
        return dewPoint;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public Double getWindGust() {
        return windGust;
    }

    public Integer getWindBearing() {
        return windBearing;
    }

    public Double getCloudCover() {
        return cloudCover;
    }

    public Integer getUvIndex() {
        return uvIndex;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public Double getOzone() {
        return ozone;
    }
}
